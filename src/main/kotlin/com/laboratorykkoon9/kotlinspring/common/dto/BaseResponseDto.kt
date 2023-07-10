package com.laboratorykkoon9.kotlinspring.common.dto

import com.fasterxml.jackson.databind.ObjectMapper
import java.io.IOException

data class BaseResponseDto<T>(
    val data: T?,
    val message: String? = null
) {
    companion object {
        fun error(message: String?) = BaseResponseDto(data = null, message = message)
        fun empty() = BaseResponseDto(data = null, message = null)
    }

    @Throws(IOException::class)
    fun convertToJson(): String {
        val mapper = ObjectMapper()
        return mapper.writeValueAsString(this)
    }
}

data class BaseResponseListDto<T>(
    val data: List<T>?,
    val message: String? = null
)
