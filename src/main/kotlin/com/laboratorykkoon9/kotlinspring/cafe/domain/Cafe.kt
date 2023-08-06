package com.laboratorykkoon9.kotlinspring.cafe.domain

import jakarta.persistence.*
import java.time.LocalTime

@Entity
@Table(name = "cafe")
class Cafe(
    name: String,
    latitude: String? = null,
    longitude: String? = null,
    mainAddress: String? = null,
    detailAddress: String? = null,
    openedAt: LocalTime? = null,
    closedAt: LocalTime? = null,
    activate: Boolean = true
) {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = 0

    @Column(name = "name")
    var name: String = name
        private set

    @Column(name = "latitude")
    var latitude: String? = latitude
        private set

    @Column(name = "longitude")
    var longitude: String? = longitude
        private set

    @Column(name = "main_address")
    var mainAddress: String? = mainAddress
        private set

    @Column(name = "detail_address")
    var detailAddress: String? = detailAddress
        private set

    @Column(name = "opened_at")
    var openedAt: LocalTime? = openedAt
        private set

    @Column(name = "closed_at")
    var closedAt: LocalTime? = closedAt
        private set

    @Column(name = "activate")
    var activate: Boolean = activate
        private set

    companion object {
        val CAFE_OPEN_TIME: LocalTime = LocalTime.of(9, 0)
        val CAFE_CLOSE_TIME: LocalTime = LocalTime.of(18, 0)
    }

    fun update(
        name: String? = null,
        latitude: String? = null,
        longitude: String? = null,
        mainAddress: String? = null,
        detailAddress: String? = null,
        openedAt: LocalTime? = null,
        closedAt: LocalTime? = null,
    ) {
        this.name = name ?: this.name
        this.latitude = latitude ?: this.latitude
        this.longitude = longitude ?: this.longitude
        this.mainAddress = mainAddress ?: this.mainAddress
        this.detailAddress = detailAddress ?: this.detailAddress
        this.openedAt = openedAt ?: this.openedAt
        this.closedAt = closedAt ?: this.closedAt
    }
}
