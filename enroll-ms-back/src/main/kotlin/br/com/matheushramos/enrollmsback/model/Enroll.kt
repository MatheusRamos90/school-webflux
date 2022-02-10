package br.com.matheushramos.enrollmsback.model

import br.com.matheushramos.enrollmsback.dtos.CourseResponse
import br.com.matheushramos.enrollmsback.dtos.StudentResponse
import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document
import java.time.Instant
import java.util.*

@Document
data class Enroll(
    @Id
    var id: String? = null,

    var course: CourseResponse,
    var student: StudentResponse,
    var inProgress: Boolean,
    var createAt: Date? = Date.from(Instant.now()),
    var updateAt: Date? = null
)