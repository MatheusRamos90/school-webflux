package br.com.matheushramos.enrollmsback.repository

import br.com.matheushramos.enrollmsback.model.Enroll
import org.springframework.data.mongodb.repository.ReactiveMongoRepository
import org.springframework.stereotype.Repository

@Repository
interface EnrollRepository : ReactiveMongoRepository<Enroll, String> {
}