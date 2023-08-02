package com.laboratorykkoon9.kotlinspring.common

import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.ControllerAdvice
import org.springframework.web.bind.annotation.ExceptionHandler

@ControllerAdvice
class GlobalExceptionHandler {

    @ExceptionHandler
    fun handleIllegalStateException(ex: IllegalArgumentException) = ResponseEntity(
            ErrorResponse(errorCode = "10001", message = ex.message),
            HttpStatus.BAD_REQUEST
        )
}
