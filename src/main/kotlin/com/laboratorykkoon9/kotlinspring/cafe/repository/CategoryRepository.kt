package com.laboratorykkoon9.kotlinspring.cafe.repository

import com.laboratorykkoon9.kotlinspring.cafe.domain.Category
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface CategoryRepository: JpaRepository<Category, Long>
