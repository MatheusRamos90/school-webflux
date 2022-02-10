package br.com.matheushramos.recordsmsback.service

import br.com.matheushramos.recordsmsback.dtos.CoursePostRequest
import br.com.matheushramos.recordsmsback.dtos.CourseResponse
import br.com.matheushramos.recordsmsback.exception.NotFoundException
import br.com.matheushramos.recordsmsback.extension.toModel
import br.com.matheushramos.recordsmsback.extension.toResponse
import br.com.matheushramos.recordsmsback.repository.CourseRepository
import org.springframework.http.HttpStatus
import org.springframework.stereotype.Service
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono
import reactor.kotlin.core.publisher.switchIfEmpty
import reactor.kotlin.core.publisher.toMono

@Service
class CourseService(private val courseRepository: CourseRepository) {

    fun create(request: CoursePostRequest): Mono<CourseResponse> =
        courseRepository.save(request.toModel()).flatMap { it.toResponse().toMono() }

    fun getAll(): Flux<CourseResponse> = courseRepository.findAll().map { cs -> cs.toResponse() }.log()

    fun getById(id: String): Mono<CourseResponse> = courseRepository.findById(id)
        .switchIfEmpty { throw NotFoundException("Course not found", HttpStatus.NOT_FOUND.value()) }
        .flatMap { Mono.just(it.toResponse()) }

}