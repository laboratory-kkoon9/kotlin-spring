package com.laboratorykkoon9.kotlinspring.cafe.repository

import com.laboratorykkoon9.kotlinspring.cafe.domain.Cafe
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository
import java.util.*

@Repository
interface CafeRepository: JpaRepository<Cafe, Long> {
    override fun findAll(page: Pageable): Page<Cafe>
    fun findByName(name: String): Optional<Cafe>
}