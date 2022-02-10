package br.com.matheushramos.recordsmsback.exception

data class BadRequestException(override var message: String, val code: Int) : Exception()