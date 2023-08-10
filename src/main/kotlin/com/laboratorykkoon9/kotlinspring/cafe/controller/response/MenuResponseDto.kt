package com.laboratorykkoon9.kotlinspring.cafe.controller.response

import com.laboratorykkoon9.kotlinspring.cafe.domain.Menu
import io.swagger.v3.oas.annotations.media.Schema

@Schema(name = "메뉴 Response")
data class MenuResponseDto(
    @Schema(description = "메뉴 PK", defaultValue = "1")
    val id: Long,
    @Schema(description = "메뉴 이름", defaultValue = "댕겸의 커피")
    val name: String,
    @Schema(description = "메뉴 가격", defaultValue = "2500")
    val price: Int,
    ) {
    companion object {
        fun of(menu: Menu) = MenuResponseDto(
            id = menu.id!!,
            name = menu.name,
            price = menu.price
        )
    }
}
