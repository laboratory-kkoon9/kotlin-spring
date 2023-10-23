package com.laboratorykkoon9.kotlinspring.cafe.service

import com.laboratorykkoon9.kotlinspring.cafe.repository.CustomMenuRepository
import com.laboratorykkoon9.kotlinspring.cafe.repository.MenuRepository
import com.laboratorykkoon9.kotlinspring.cafe.service.model.GetMenuInfo
import mu.KotlinLogging
import org.springframework.data.domain.Pageable
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class MenuService(
    private val menuRepository: MenuRepository,
) {
    val logger = KotlinLogging.logger {}

    suspend fun getMenus(
        param: GetMenuInfo,
        pageable: Pageable
    ) = menuRepository.findMenu(param = param.toParam(), pageable = pageable)
}

fun GetMenuInfo.toParam() = CustomMenuRepository.MenuParameter(
    cafeId = cafeId,
)