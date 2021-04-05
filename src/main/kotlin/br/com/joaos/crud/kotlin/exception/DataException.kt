package br.com.joaos.crud.kotlin.exception

import org.springframework.http.HttpStatus
import java.lang.RuntimeException

class DataException constructor(message: String?, httpStatus: HttpStatus, e: Throwable?) : RuntimeException(message, e, false, false){
	override var message: String? = ""
	var httpStatus: HttpStatus = HttpStatus.FOUND

	constructor(message: String?, httpStatus: HttpStatus) : this(message, httpStatus, null){
		this.message = message
		this.httpStatus = httpStatus

	}

}
