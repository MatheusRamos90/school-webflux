package br.com.matheushramos.enrollmsback.dtos

data class ErrorResponse(
    var message: String,
    var code: Int,
    var error: MutableList<String>? = null,
)