package br.com.matheushramos.recordsmsback.repository

import br.com.matheushramos.recordsmsback.models.Student
import org.springframework.data.mongodb.repository.ReactiveMongoRepository
import org.springframework.stereotype.Repository
import reactor.core.publisher.Mono

@Repository
interface StudentRepository : ReactiveMongoRepository<Student, String> {

    fun findByEmail(email: String): Mono<Student>

}