package com.laboratorykkoon9.kotlinspring.cafe.domain

import com.laboratorykkoon9.kotlinspring.common.BaseEntity
import jakarta.persistence.*
import org.hibernate.type.EnumType

@Entity
@Table(name = "cafe_menus")
class Menu(
    category: Category,
    name: String,
    price: Int,
    soldOut: Boolean = false,
) : BaseEntity() {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null

    @Column(name = "category")
    @Enumerated(jakarta.persistence.EnumType.STRING)
    var category: Category = category
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

    enum class Category(val description: String) {
        COFFEE("커피 종류"),
        COLD_BREW("콜드브루"),
        TEA("차 종류"),
        ICE_BLENDED("쉐이크 및 프라페"),
        BLENDED_FRUIT("과일 주스 및 라떼"),
        ADE("에이드"),
        FRUIT_TEA("과일티"),
        ICE_CREAM("아이스크림"),
        THE_OTHERS("그 외 메뉴")
    }
}
