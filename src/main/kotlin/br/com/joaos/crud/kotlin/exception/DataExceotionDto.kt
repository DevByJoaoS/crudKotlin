package br.com.joaos.crud.kotlin.exception

import java.util.*

class DataExceotionDto(
    var timestamp: Date,
    var message: String?,
    var status: Int,
    var error: String,
    var path: String)