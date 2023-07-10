package com.laboratorykkoon9.kotlinspring.cafe.service

import com.laboratorykkoon9.kotlinspring.cafe.dto.CafeInfoResponseDto
import org.springframework.stereotype.Service

@Service
class CafeService {
    fun getCafeInfo(): CafeInfoResponseDto {
        return CafeInfoResponseDto(
            openedTime = CAFE_OPEN_TIME,
            closedTime = CAFE_CLOSE_TIME,
        )
    }
    companion object {
        const val CAFE_OPEN_TIME: String = "09:00"
        const val CAFE_CLOSE_TIME: String = "17:00"
    }
}
