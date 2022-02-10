package br.com.matheushramos.enrollmsback.exception

data class RecordClientException(override var message: String, val code: Int) : Exception()