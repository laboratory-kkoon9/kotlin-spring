package com.laboratorykkoon9.kotlinspring.cafe.domain

import com.laboratorykkoon9.kotlinspring.common.BaseEntity
import jakarta.persistence.*
import java.time.LocalTime

@Entity
@Table(name = "cafes")
class Cafe(
    name: String,
    latitude: String? = null,
    longitude: String? = null,
    mainAddress: String? = null,
    detailAddress: String? = null,
    openedAt: LocalTime? = null,
    closedAt: LocalTime? = null,
    activate: Boolean = true
) : BaseEntity() {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null

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

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "cafe")
    val menus: MutableSet<CafeMenuOption> = mutableSetOf()


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

    fun updateStatus() {
        this.activate = !this.activate
    }
}
