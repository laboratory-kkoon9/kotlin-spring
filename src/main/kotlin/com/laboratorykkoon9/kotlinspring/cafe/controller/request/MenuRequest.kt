package com.laboratorykkoon9.kotlinspring.cafe.controller.request

import io.swagger.v3.oas.annotations.media.Schema

@Schema(name = "메뉴 조회 Request")
data class MenuRequest(
    @Schema(description = "카페 Id", defaultValue = "1")
    val cafeId: Long,
    @Schema(description = "카테고리 Id", defaultValue = "1")
    val categoryId: Long?,
)
