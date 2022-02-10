package br.com.matheushramos.enrollmsback.exception

data class NotFoundException(override var message: String, val code: Int) : Exception()