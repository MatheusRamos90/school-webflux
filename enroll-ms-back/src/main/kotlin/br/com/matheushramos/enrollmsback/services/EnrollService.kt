package br.com.matheushramos.enrollmsback.services

import br.com.matheushramos.enrollmsback.clients.RecordsRestClient
import br.com.matheushramos.enrollmsback.dtos.EnrollPostRequest
import br.com.matheushramos.enrollmsback.dtos.EnrollResponse
import br.com.matheushramos.enrollmsback.exception.NotFoundException
import br.com.matheushramos.enrollmsback.extension.toDTO
import br.com.matheushramos.enrollmsback.extension.toModel
import br.com.matheushramos.enrollmsback.extension.toResponse
import br.com.matheushramos.enrollmsback.repository.EnrollRepository
import org.springframework.http.HttpStatus
import org.springframework.stereotype.Service
import reactor.core.publisher.Mono
import reactor.kotlin.core.publisher.switchIfEmpty
import reactor.kotlin.core.publisher.toMono

@Service
class EnrollService(
    private val enrollRepository: EnrollRepository,
    private val recordsRestClient: RecordsRestClient) {

    fun create(request: EnrollPostRequest): Mono<EnrollResponse> {
        val student = recordsRestClient.retrieveStudent(request.studentId).let { it.toDTO(it.block()) }
        val course = recordsRestClient.exchangeCourse(request.courseId).let { it.toDTO(it.block()) }
        return enrollRepository.save(request.toModel(student, course)).flatMap { it.toResponse().toMono() }
    }

    fun getById(id: String): Mono<EnrollResponse> = enrollRepository.findById(id)
        .switchIfEmpty { throw NotFoundException("Enroll not found", HttpStatus.NOT_FOUND.value()) }
        .flatMap { Mono.just(it.toResponse()) }

}