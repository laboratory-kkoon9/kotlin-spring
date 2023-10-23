package com.laboratorykkoon9.kotlinspring.cafe.repository

import com.laboratorykkoon9.kotlinspring.cafe.domain.Menu
import com.laboratorykkoon9.kotlinspring.cafe.domain.QCafeMenuOption.cafeMenuOption
import com.laboratorykkoon9.kotlinspring.cafe.domain.QMenu
import com.laboratorykkoon9.kotlinspring.cafe.domain.QMenu.menu
import com.laboratorykkoon9.kotlinspring.cafe.domain.QMenuOption.menuOption
import com.querydsl.jpa.impl.JPAQueryFactory
import org.springframework.data.domain.Page
import org.springframework.data.domain.PageImpl
import org.springframework.data.domain.Pageable
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface MenuRepository : JpaRepository<Menu, Long>, CustomMenuRepository

interface CustomMenuRepository {
    fun findMenu(
        param: MenuParameter,
        pageable: Pageable
    ): Page<Menu>

    data class MenuParameter(
        val cafeId: Long,
    )
}

class CustomMenuRepositoryImpl(
    private val queryFactory: JPAQueryFactory
) : CustomMenuRepository {
    override fun findMenu(param: CustomMenuRepository.MenuParameter, pageable: Pageable): Page<Menu> {


        val query = queryFactory.query()
            .from(cafeMenuOption)


        val totalCount = query.fetch().size.toLong()

        val menus = query.select(menu)
            .offset(pageable.offset)
            .limit(pageable.pageSize.toLong())
            .fetch()

        return PageImpl(menus, pageable, totalCount)
    }
}
