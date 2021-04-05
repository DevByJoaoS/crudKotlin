package br.com.joaos.crud.kotlin.exception

import org.springframework.http.HttpStatus
import java.lang.RuntimeException

class DataException (
		override val message: String,
		val httpStatus: HttpStatus): RuntimeException()
