package com.laboratorykkoon9.kotlinspring.cafe.repository

import com.laboratorykkoon9.kotlinspring.cafe.domain.Menu
import com.laboratorykkoon9.kotlinspring.cafe.domain.QMenu
import com.querydsl.jpa.impl.JPAQueryFactory
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface MenuRepository: JpaRepository<Menu, Long>, CustomMenuRepository


interface CustomMenuRepository {
    fun findByCafeId(cafeId: Long): MutableList<Menu>?
}

class CustomMenuRepositoryImpl(
    private val queryFactory: JPAQueryFactory
): CustomMenuRepository {
    override fun findByCafeId(cafeId: Long): MutableList<Menu>? {
        val menu = QMenu.menu

        return queryFactory.query()
            .select(menu)
            .from(menu)
            .fetch()

    }
}
