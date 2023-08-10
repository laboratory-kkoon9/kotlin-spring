package com.laboratorykkoon9.kotlinspring.cafe.service

import com.laboratorykkoon9.kotlinspring.cafe.repository.CategoryRepository
import com.laboratorykkoon9.kotlinspring.cafe.repository.MenuRepository
import com.laboratorykkoon9.kotlinspring.cafe.service.model.GetCafeInfo
import mu.KotlinLogging
import org.springframework.data.domain.Pageable
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class MenuService(
    private val menuRepository: MenuRepository,
    private val categoryRepository: CategoryRepository,
) {
    val logger = KotlinLogging.logger {}

    @Transactional(readOnly = true)
    suspend fun getMenus(
        cafeId: Long,
        pageable: Pageable
    ) {

    }

}