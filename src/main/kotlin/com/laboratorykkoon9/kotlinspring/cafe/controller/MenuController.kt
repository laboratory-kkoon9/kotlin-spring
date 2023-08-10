package com.laboratorykkoon9.kotlinspring.cafe.controller

import com.laboratorykkoon9.kotlinspring.cafe.controller.request.MenuRequest
import com.laboratorykkoon9.kotlinspring.cafe.controller.response.MenuResponseDto
import com.laboratorykkoon9.kotlinspring.cafe.service.MenuService
import com.laboratorykkoon9.kotlinspring.cafe.service.model.GetCafeInfo
import com.laboratorykkoon9.kotlinspring.cafe.service.model.GetMenuInfo
import com.laboratorykkoon9.kotlinspring.common.Response
import io.swagger.v3.oas.annotations.Operation
import io.swagger.v3.oas.annotations.media.Content
import io.swagger.v3.oas.annotations.media.Schema
import io.swagger.v3.oas.annotations.responses.ApiResponse
import io.swagger.v3.oas.annotations.responses.ApiResponses
import kotlinx.coroutines.runBlocking
import org.springframework.data.domain.Pageable
import org.springframework.data.web.PageableDefault
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/v1/cafe-menu")
class MenuController(
    private val menuService: MenuService
) {
    @Operation(summary = "카페 정보 API", description = "카페 정보를 가져오는 API")
    @ApiResponses(
        ApiResponse(
            responseCode = "200",
            content = [
                Content(
                    mediaType = "application/json",
                    schema = Schema(implementation = GetCafeInfo::class),
                ),
            ],
        ),
    )
    @GetMapping
    fun getCafeInfo(
        request: MenuRequest,
        @PageableDefault(page = 0, size = 30) pageable: Pageable
    ) = runBlocking { menuService.getMenus(request.toParam(), pageable) }
        .map { MenuResponseDto.of(it) }
        .let { Response.pageOf(it) }
}

fun MenuRequest.toParam() = GetMenuInfo(
    cafeId = cafeId,
    categoryId = categoryId
)
