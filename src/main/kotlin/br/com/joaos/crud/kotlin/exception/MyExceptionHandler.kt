package br.com.joaos.crud.kotlin.exception

import com.sun.istack.Nullable
import lombok.extern.slf4j.Slf4j
import org.springframework.http.HttpHeaders
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.ControllerAdvice
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.context.request.WebRequest
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler
import java.lang.Exception
import java.util.*

@ControllerAdvice
@Slf4j
class MyExceptionHandler: ResponseEntityExceptionHandler() {

    @ExceptionHandler(DataException::class)
    protected fun handleConflict(ex: DataException, request: WebRequest): ResponseEntity<Any> {
        return this.handleExceptionInternal(ex, null, HttpHeaders(), ex.httpStatus, request)
    }


    override fun handleExceptionInternal(ex: Exception, body: Any?, headers: HttpHeaders,
        status: HttpStatus, request: WebRequest): ResponseEntity<Any> {
        val dataException = DataExceotionDto(
            Date(),
            ex.message,
            Objects.requireNonNullElse(status, HttpStatus.INTERNAL_SERVER_ERROR).value(),
            Objects.requireNonNullElse(status, HttpStatus.INTERNAL_SERVER_ERROR).getReasonPhrase(),
            request.getDescription(false)
        )
        return  ResponseEntity(dataException,
        headers,
        Objects.requireNonNullElse(status, HttpStatus.INTERNAL_SERVER_ERROR)
        )
    }
}