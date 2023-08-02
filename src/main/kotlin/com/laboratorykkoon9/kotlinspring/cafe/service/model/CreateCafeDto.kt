package com.laboratorykkoon9.kotlinspring.cafe.service.model

import com.laboratorykkoon9.kotlinspring.cafe.domain.Cafe
import java.time.LocalTime

data class CreateCafeDto(
    val name: String,
    val latitude: String?,
    val longitude: String?,
    val mainAddress: String?,
    val detailAddress: String?,
    val openedAt: LocalTime?,
    val closedAt: LocalTime?,
) {
    fun toEntity() = Cafe(
        name = this.name,
        latitude = this.latitude,
        longitude = this.longitude,
        mainAddress = this.mainAddress,
        detailAddress = this.detailAddress,
        openedAt = this.openedAt,
        closedAt = this.closedAt,
    )
}
