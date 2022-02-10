package br.com.matheushramos.recordsmsback.controller

import br.com.matheushramos.recordsmsback.dtos.StudentPostRequest
import br.com.matheushramos.recordsmsback.dtos.StudentResponse
import br.com.matheushramos.recordsmsback.service.StudentService
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono
import java.net.URI
import javax.validation.Valid

@RestController
@RequestMapping("/v1/student")
class StudentController(private var studentService: StudentService) {

    @PostMapping
    fun create(@RequestBody @Valid request: StudentPostRequest): ResponseEntity<Mono<StudentResponse>> =
        ResponseEntity.created(URI("")).body(studentService.create(request))

    @GetMapping
    fun getAll(): Flux<StudentResponse> = studentService.getAll()

    @GetMapping("/{id}")
    fun getById(@PathVariable id: String): ResponseEntity<Mono<StudentResponse>> =
        ResponseEntity.ok(studentService.getById(id))

}