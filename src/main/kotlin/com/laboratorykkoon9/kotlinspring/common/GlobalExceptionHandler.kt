package com.laboratorykkoon9.kotlinspring.common

import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.MethodArgumentNotValidException
import org.springframework.web.bind.annotation.ControllerAdvice
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.support.WebExchangeBindException
import org.springframework.web.server.ServerWebInputException

@ControllerAdvice
class GlobalExceptionHandler {

    @ExceptionHandler(IllegalArgumentException::class)
    fun handleIllegalStateException(ex: IllegalArgumentException) = ResponseEntity(
            ErrorResponse(errorCode = "10001", message = ex.message),
            HttpStatus.BAD_REQUEST
        )

    /**
     * javax.validation.Valid or @Validated 으로 binding error 발생시 발생한다.
     * HttpMessageConverter 에서 등록한 HttpMessageConverter binding 못할경우 발생
     * 주로 @RequestBody, @RequestPart 어노테이션에서 발생
     */
    @ExceptionHandler(WebExchangeBindException::class)
    protected fun handleWebExchangeBindException(ex: WebExchangeBindException): ResponseEntity<ErrorResponse> {
        val message = ex.bindingResult
            .allErrors[0]
            .defaultMessage
        return ResponseEntity(
            ErrorResponse(errorCode = "10001", message = message),
            HttpStatus.BAD_REQUEST
        )
    }

    /**
     * javax.validation.Valid or @Validated 으로 binding error 발생시 발생한다.
     * HttpMessageConverter 에서 등록한 HttpMessageConverter binding 못할경우 발생
     * 주로 @RequestBody, @RequestPart 어노테이션에서 발생
     */
    @ExceptionHandler(ServerWebInputException::class)
    protected fun handleServerWebInputException(ex: ServerWebInputException): ResponseEntity<ErrorResponse> {
        val message = "${ex.methodParameter.parameter.name}의 validation 규칙을 다시 검토하세요."
        return ResponseEntity(
            ErrorResponse(errorCode = "10001", message = message),
            HttpStatus.BAD_REQUEST
        )
    }

    @ExceptionHandler(Exception::class)
    protected fun handleException(ex: Exception) = ResponseEntity(
        ErrorResponse(errorCode = "10001", message = ex.message),
        HttpStatus.BAD_REQUEST
    )

}
