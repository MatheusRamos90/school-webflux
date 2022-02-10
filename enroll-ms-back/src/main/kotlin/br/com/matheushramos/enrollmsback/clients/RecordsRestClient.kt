package br.com.matheushramos.enrollmsback.clients

import br.com.matheushramos.enrollmsback.dtos.CourseResponse
import br.com.matheushramos.enrollmsback.dtos.StudentResponse
import br.com.matheushramos.enrollmsback.exception.RecordClientException
import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Value
import org.springframework.http.HttpStatus
import org.springframework.http.HttpStatus.NOT_FOUND
import org.springframework.http.HttpStatus.OK
import org.springframework.stereotype.Component
import org.springframework.web.reactive.function.client.WebClient
import reactor.core.publisher.Mono

@Component
class RecordsRestClient(private val webClient: WebClient) {

    @Value("\${restClient.studentUrl}")
    private val studentUrl: String? = null

    @Value("\${restClient.courseUrl}")
    private val courseUrl: String? = null

    private val log = LoggerFactory.getLogger(this.javaClass)

    fun retrieveStudent(id: String): Mono<StudentResponse> {
        val url = "${studentUrl}/{id}"

        return webClient.get()
            .uri(url, id)
            .retrieve()
            .onStatus(HttpStatus::is4xxClientError) { clientResponse ->
                log.error("Status code: ${clientResponse.statusCode().value()}")
                if (clientResponse.statusCode() == NOT_FOUND) {
                    return@onStatus Mono.error(RecordClientException("There is no Student avaiable with this Id $id", clientResponse.statusCode().value()))
                }
                return@onStatus clientResponse.bodyToMono(String::class.java)
                    .flatMap { response ->
                        Mono.error(
                            RecordClientException(
                                response,
                                clientResponse.statusCode().value()
                            )
                        )
                    }
            }
            .bodyToMono(StudentResponse::class.java)
//            .retryWhen(Retry.fixedDelay(3, Duration.ofMillis(500)))
            .log()
    }

    fun exchangeCourse(id: String): Mono<CourseResponse> {
        val url = "${courseUrl}/{id}"

        return webClient.get()
            .uri(url, id)
            .exchangeToMono {
                log.error("Status code: ${it.statusCode().value()}")
                when (it.statusCode()) {
                    OK -> it.bodyToMono(CourseResponse::class.java)
                    NOT_FOUND -> Mono.error(RecordClientException("There is no Course available with this Id $id", it.statusCode().value()))
                    else -> it.bodyToMono(String::class.java).flatMap { response -> Mono.error(RecordClientException(response, it.statusCode().value())) }
                }
            }
//            .retryWhen(Retry.fixedDelay(3, Duration.ofMillis(500)))
            .log()
    }

}