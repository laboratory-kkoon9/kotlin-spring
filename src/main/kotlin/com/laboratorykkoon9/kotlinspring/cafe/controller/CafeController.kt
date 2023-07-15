package com.laboratorykkoon9.kotlinspring.cafe

import com.laboratorykkoon9.kotlinspring.cafe.dto.CafeInfoResponseDto
import com.laboratorykkoon9.kotlinspring.cafe.service.CafeService
import kotlinx.coroutines.runBlocking
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController


@RestController
@RequestMapping("/api/v1/cafe")
class CafeController(
    private val cafeService: CafeService
) {

    @GetMapping
    fun getCafeInfo(): ResponseEntity<CafeInfoResponseDto> {
        val cafeInfo = runBlocking {
            cafeService.getCafeInfo()
        }
        return ResponseEntity.status(200).body(cafeInfo)
    }
}
