package com.laboratorykkoon9.kotlinspring.cafe.controller.response

import com.laboratorykkoon9.kotlinspring.cafe.domain.Cafe
import java.time.LocalTime

class CafeItem(
    val id: Long?,
    val name: String?,
    val latitude: String?,
    val longitude: String?,
    val mainAddress: String?,
    val detailAddress: String?,
    val openedAt: LocalTime?,
    val closedAt: LocalTime?,
) {
    companion object {
        fun of(cafe: Cafe) = CafeItem(
            id = cafe.id,
            name = cafe.name,
            latitude = cafe.latitude,
            longitude = cafe.longitude,
            mainAddress = cafe.mainAddress,
            detailAddress = cafe.detailAddress,
            openedAt = cafe.openedAt,
            closedAt = cafe.closedAt,
        )
    }

}
