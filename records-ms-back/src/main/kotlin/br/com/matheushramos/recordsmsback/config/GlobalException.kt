package br.com.matheushramos.recordsmsback.config

import br.com.matheushramos.recordsmsback.dtos.ErrorResponse
import br.com.matheushramos.recordsmsback.exception.BadRequestException
import br.com.matheushramos.recordsmsback.exception.NotFoundException
import org.slf4j.LoggerFactory
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.ControllerAdvice
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.ResponseBody

@ControllerAdvice
class GlobalException {

    private val log = LoggerFactory.getLogger(this.javaClass)

    @ExceptionHandler(value = [NotFoundException::class])
    @ResponseBody
    fun handleNotFoundException(ex: NotFoundException): ResponseEntity<ErrorResponse> {
        log.error("There was exception => Error: $ex")
        return ResponseEntity.status(ex.code).body(ErrorResponse(ex.message, ex.code))
    }

    @ExceptionHandler(value = [BadRequestException::class])
    @ResponseBody
    fun handleBadRequestException(ex: BadRequestException): ResponseEntity<ErrorResponse> {
        log.error("There was exception => Error: $ex")
        return ResponseEntity.status(ex.code).body(ErrorResponse(ex.message, ex.code))
    }

}