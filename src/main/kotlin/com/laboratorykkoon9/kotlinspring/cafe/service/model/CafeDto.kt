package com.laboratorykkoon9.kotlinspring.cafe.service.model

import com.laboratorykkoon9.kotlinspring.cafe.domain.Cafe
import java.time.LocalTime

data class CreateCafeDto(
    val name: String,
    val latitude: String? = null,
    val longitude: String? = null,
    val mainAddress: String? = null,
    val detailAddress: String? = null,
    val openedAt: LocalTime? = null,
    val closedAt: LocalTime? = null,
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

data class UpdateCafeDto(
    val id: Long,
    val name: String? = null,
    val latitude: String? = null,
    val longitude: String? = null,
    val mainAddress: String? = null,
    val detailAddress: String? = null,
    val openedAt: LocalTime? = null,
    val closedAt: LocalTime? = null,
)
