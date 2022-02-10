package br.com.matheushramos.recordsmsback.service

import br.com.matheushramos.recordsmsback.dtos.StudentPostRequest
import br.com.matheushramos.recordsmsback.dtos.StudentResponse
import br.com.matheushramos.recordsmsback.exception.NotFoundException
import br.com.matheushramos.recordsmsback.extension.toModel
import br.com.matheushramos.recordsmsback.extension.toResponse
import br.com.matheushramos.recordsmsback.models.Student
import br.com.matheushramos.recordsmsback.repository.StudentRepository
import lombok.extern.slf4j.Slf4j
import org.springframework.http.HttpStatus
import org.springframework.stereotype.Service
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono
import reactor.kotlin.core.publisher.switchIfEmpty
import reactor.kotlin.core.publisher.toMono

@Service
@Slf4j
class StudentService(private val studentRepository: StudentRepository) {

    fun create(request: StudentPostRequest): Mono<StudentResponse> =
        studentRepository.findByEmail(request.email)
            .flatMap { Mono.error<Student>(NotFoundException("Student already exists", HttpStatus.BAD_REQUEST.value())) }
            .switchIfEmpty {
                studentRepository.save(request.toModel())
            }
            .flatMap { it.toResponse().toMono() }

    fun getAll(): Flux<StudentResponse> = studentRepository.findAll().map { st -> st.toResponse() }.log()

    fun getById(id: String): Mono<StudentResponse> = studentRepository.findById(id)
        .switchIfEmpty { throw NotFoundException("Student not found", HttpStatus.NOT_FOUND.value()) }
        .flatMap { Mono.just(it.toResponse()) }

}