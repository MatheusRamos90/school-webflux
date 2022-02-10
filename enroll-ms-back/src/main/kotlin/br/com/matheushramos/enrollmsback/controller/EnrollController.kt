package br.com.matheushramos.enrollmsback.controller

import br.com.matheushramos.enrollmsback.dtos.EnrollPostRequest
import br.com.matheushramos.enrollmsback.dtos.EnrollResponse
import br.com.matheushramos.enrollmsback.services.EnrollService
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import reactor.core.publisher.Mono
import java.net.URI
import javax.validation.Valid

@RestController
@RequestMapping("/v1/enroll")
class EnrollController(private val enrollService: EnrollService) {

    @PostMapping
    fun create(@RequestBody @Valid request: EnrollPostRequest): ResponseEntity<Mono<EnrollResponse>> =
        ResponseEntity.created(URI("")).body(enrollService.create(request))

    @GetMapping("/{id}")
    fun getById(@PathVariable id: String): ResponseEntity<Mono<EnrollResponse>> =
        ResponseEntity.ok(enrollService.getById(id))

}