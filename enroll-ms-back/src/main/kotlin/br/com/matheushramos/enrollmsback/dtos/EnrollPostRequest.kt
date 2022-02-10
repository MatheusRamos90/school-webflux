package br.com.matheushramos.enrollmsback.dtos

import com.fasterxml.jackson.annotation.JsonAlias
import javax.validation.constraints.NotBlank
import javax.validation.constraints.NotEmpty
import javax.validation.constraints.NotNull

data class EnrollPostRequest(
    @field:NotNull(message = "student_id is required")
    @field:NotBlank(message = "student_id is required")
    @JsonAlias("student_id")
    var studentId: String,

    @field:NotEmpty(message = "course_id is required")
    @field:NotBlank(message = "course_id is required")
    @JsonAlias("course_id")
    var courseId: String
)