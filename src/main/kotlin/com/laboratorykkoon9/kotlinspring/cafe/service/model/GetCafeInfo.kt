package com.laboratorykkoon9.kotlinspring.cafe.service.model

import com.laboratorykkoon9.kotlinspring.cafe.domain.Cafe
import java.time.LocalTime

data class GetCafeInfo(
    val id: Long,
    val name: String,
    val latitude: String?,
    val longitude: String?,
    val mainAddress: String?,
    val detailAddress: String?,
    val openedTime: LocalTime?,
    val closedTime: LocalTime?,
) {
    companion object {
        fun of(cafe: Cafe) = GetCafeInfo(
            id = cafe.id!!,
            name = cafe.name,
            latitude = cafe.latitude,
            longitude = cafe.longitude,
            mainAddress = cafe.mainAddress,
            detailAddress = cafe.detailAddress,
            openedTime = cafe.openedAt,
            closedTime = cafe.closedAt,
        )
    }
}