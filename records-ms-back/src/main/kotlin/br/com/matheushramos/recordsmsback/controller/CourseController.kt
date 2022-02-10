package br.com.matheushramos.recordsmsback.controller

import br.com.matheushramos.recordsmsback.dtos.CoursePostRequest
import br.com.matheushramos.recordsmsback.dtos.CourseResponse
import br.com.matheushramos.recordsmsback.service.CourseService
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono
import java.net.URI
import javax.validation.Valid

@RestController
@RequestMapping("/v1/course")
class CourseController(private val courseService: CourseService) {

    @PostMapping
    fun create(@RequestBody @Valid request: CoursePostRequest): ResponseEntity<Mono<CourseResponse>> =
        ResponseEntity.created(URI("")).body(courseService.create(request))

    @GetMapping
    fun getAll(): Flux<CourseResponse> = courseService.getAll()

    @GetMapping("/{id}")
    fun getById(@PathVariable id: String): ResponseEntity<Mono<CourseResponse>> =
        ResponseEntity.ok(courseService.getById(id))

}