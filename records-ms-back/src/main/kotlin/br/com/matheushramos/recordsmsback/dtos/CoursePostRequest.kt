package br.com.matheushramos.recordsmsback.dtos

import java.math.BigDecimal
import javax.validation.constraints.Min
import javax.validation.constraints.NotBlank
import javax.validation.constraints.NotEmpty
import javax.validation.constraints.NotNull

data class CoursePostRequest(
    @field:NotEmpty(message = "name is required")
    @field:NotBlank(message = "name is required")
    var name: String,

    @field:NotNull(message = "price is required")
    @field:Min(0)
    var price: BigDecimal
)