package br.com.matheushramos.recordsmsback.repository

import br.com.matheushramos.recordsmsback.models.Course
import org.springframework.data.mongodb.repository.ReactiveMongoRepository
import org.springframework.stereotype.Repository

@Repository
interface CourseRepository : ReactiveMongoRepository<Course, String> {
}