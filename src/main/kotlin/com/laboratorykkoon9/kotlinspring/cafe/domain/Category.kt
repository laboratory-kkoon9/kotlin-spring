package com.laboratorykkoon9.kotlinspring.cafe.domain

import com.laboratorykkoon9.kotlinspring.common.BaseEntity
import jakarta.persistence.*

@Entity
@Table(name = "cafe_menu")
class Category(
    cafeId: Long,
    name: String
) : BaseEntity() {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null
    var name: String = name
        private set

    @Column(name = "cafe_id")
    var cafeId: Long = cafeId
        private set
}