package br.com.matheushramos.recordsmsback.dtos

import javax.validation.constraints.Email
import javax.validation.constraints.NotEmpty

data class StudentPostRequest(
    @field:NotEmpty(message = "name need be filled")
    var name: String,

    @field:Email(message = "email is not valid")
    var email: String,

    @field:NotEmpty(message = "password is required")
    var password: String,

    @field:NotEmpty(message = "numberDocument is required")
    var numberDocument: String
)