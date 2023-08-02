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
    val name: String = name

    @Column(name = "latitude")
    val latitude: String? = latitude

    @Column(name = "longitude")
    val longitude: String? = longitude

    @Column(name = "main_address")
    val mainAddress: String? = mainAddress

    @Column(name = "detail_address")
    val detailAddress: String? = detailAddress

    @Column(name = "opened_at")
    val openedAt: LocalTime? = openedAt

    @Column(name = "closed_at")
    val closedAt: LocalTime? = closedAt

    @Column(name = "activate")
    val activate: Boolean = activate

    companion object {
        val CAFE_OPEN_TIME: LocalTime = LocalTime.of(9, 0)
        val CAFE_CLOSE_TIME: LocalTime = LocalTime.of(18, 0)
    }
}
