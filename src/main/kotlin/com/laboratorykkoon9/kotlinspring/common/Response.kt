package com.laboratorykkoon9.kotlinspring.common

import io.swagger.v3.oas.annotations.media.Schema
import org.springframework.data.domain.Page

interface Response<T> {
    val data: T

    companion object {
        fun <T> of(data: T) : Response<T> = DefaultResponse(data)
        fun <T> empty(): Response<T?> = DefaultResponse(null)
        fun <T> pageOf(data: Page<T>): PageResponse<T> = PageResponse(
            data = data.content,
            number = data.pageable.pageNumber,
            size = data.content.size,
            totalPages = data.totalPages,
            totalElements = data.totalElements,
        )
    }
}

data class DefaultResponse<T> (override val data: T) : Response<T>

data class PageResponse<T>(
    @Schema(
        title = "데이터 목록",
    )
    override val data: List<T>,

    @Schema(
        title = "페이지 번호",
        description = "0이 시작",
        example = "0",
    )
    val number: Int,

    @Schema(
        title = "한 페이지의 데이터 개수",
        example = "10",
    )
    val size: Int,

    @Schema(
        title = "총 페이지 개수",
        example = "10",
    )
    val totalPages: Int,

    @Schema(
        title = "총 데이터 개수",
        example = "1024",
    )
    val totalElements: Long,
) : Response<List<T>>

data class ErrorResponse(
    val errorCode: String,
    val message: String?,
)
