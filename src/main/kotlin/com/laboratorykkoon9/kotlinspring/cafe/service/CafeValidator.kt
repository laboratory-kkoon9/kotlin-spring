package com.laboratorykkoon9.kotlinspring.cafe.service

import com.laboratorykkoon9.kotlinspring.cafe.repository.CafeRepository
import org.springframework.stereotype.Service

@Service
class CafeValidator(
    private val cafeRepository: CafeRepository,
) {
    fun createValidator(name: String) {
        if(cafeRepository.existsByName(name)) {
            throw IllegalArgumentException("${name}은(는) 이미 존재하는 이름입니다.")
        }
    }
}