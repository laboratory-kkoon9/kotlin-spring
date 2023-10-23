package com.laboratorykkoon9.kotlinspring.cafe.domain

import com.laboratorykkoon9.kotlinspring.common.BaseEntity
import jakarta.persistence.*

@Entity
@Table(name = "cafe_menu_options")
class CafeMenuOption(
    cafe: Cafe,
    menuOption: MenuOption,
): BaseEntity() {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "cafe_id")
    var cafe: Cafe = cafe
        private set

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "menu_id")
    var menuOption: MenuOption = menuOption
        private set
}
