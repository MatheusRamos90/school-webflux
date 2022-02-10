package br.com.matheushramos.recordsmsback.exception

data class NotFoundException(override var message: String, val code: Int) : Exception()