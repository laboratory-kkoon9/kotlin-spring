package com.laboratorykkoon9.kotlinspring.cafe.domain

import com.laboratorykkoon9.kotlinspring.common.BaseEntity
import jakarta.persistence.*

@Entity
@Table(name = "cafe_menu")
class Menu(
    categoryId: Long,
    name: String,
    price: Int,
    soldOut: Boolean = false,
) : BaseEntity() {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null

    @Column(name = "category_id")
    var categoryId: Long = categoryId
        private set

    @Column(name = "menu_name")
    var name: String = name
        private set

    @Column(name = "price")
    var price: Int = price
        private set

    @Column(name = "sold_out")
    var soldOut: Boolean = soldOut
        private set
}
