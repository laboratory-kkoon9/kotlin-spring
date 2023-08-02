package com.laboratorykkoon9.kotlinspring.cafe.controller

import com.laboratorykkoon9.kotlinspring.cafe.controller.request.CreateCafeRequest
import com.laboratorykkoon9.kotlinspring.cafe.controller.response.CafeItem
import com.laboratorykkoon9.kotlinspring.cafe.service.CafeService
import com.laboratorykkoon9.kotlinspring.cafe.service.model.CreateCafeDto
import com.laboratorykkoon9.kotlinspring.cafe.service.model.GetCafeInfo
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
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController


@RestController
@RequestMapping("/api/v1/cafe")
class CafeController(
    private val cafeService: CafeService
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
        @PageableDefault(page = 0, size = 30) pageable: Pageable
    ) = runBlocking {
        cafeService.getCafeInfo(pageable)
    }.let {
        Response.pageOf(it)
    }

    @Operation(summary = "카페 생성 API", description = "카페를 새로 만드는 API")
    @ApiResponses(
        ApiResponse(
            responseCode = "200",
            content = [
                Content(
                    mediaType = "application/json",
                    schema = Schema(implementation = CafeItem::class),
                ),
            ],
        ),
    )
    @PostMapping
    fun createCafe(
        @RequestBody createCafeRequest: CreateCafeRequest
    ) = runBlocking {
        cafeService.createCafe(createCafeRequest.toRequest())
    }
        .let { CafeItem.of(it) }
        .let { Response.of(it) }
}

fun CreateCafeRequest.toRequest() = CreateCafeDto(
    name, latitude, longitude, mainAddress, detailAddress, openedAt, closedAt
)
