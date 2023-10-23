package com.laboratorykkoon9.kotlinspring.cafe.domain

import com.laboratorykkoon9.kotlinspring.common.BaseEntity
import jakarta.persistence.*

@Entity
@Table(name = "menu_options")
class MenuOption(
    menu: Menu,
    option: Option
): BaseEntity() {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "menu_id")
    var menu: Menu = menu
        private set

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "option_id")
    var option: Option = option
        private set
}
