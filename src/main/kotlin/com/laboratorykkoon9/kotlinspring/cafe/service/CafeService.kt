package com.laboratorykkoon9.kotlinspring.cafe.service

import com.laboratorykkoon9.kotlinspring.cafe.repository.CafeRepository
import com.laboratorykkoon9.kotlinspring.cafe.service.model.CreateCafeDto
import com.laboratorykkoon9.kotlinspring.cafe.service.model.GetCafeInfo
import mu.KotlinLogging
import org.springframework.data.domain.Pageable
import org.springframework.stereotype.Service

@Service
class CafeService(
    private val cafeRepository: CafeRepository
) {
    val logger = KotlinLogging.logger {}

    suspend fun getCafeInfo(
        pageable: Pageable
    ) = cafeRepository.findAll(pageable)
        .also { logger.info("조회된 카페의 개수는 ${it.content.size}입니다.") }
        .map { GetCafeInfo.of(it) }

    suspend fun createCafe(
        cafeDto: CreateCafeDto
    ) = cafeDto.toEntity()
        .also {
            val cafe = cafeRepository.findByName(it.name)
            if (cafe.isPresent) {
                throw IllegalArgumentException("이미 존재하는 이름입니다.")
            }
        }
        .also { cafeRepository.save(it) }
        .also { logger.info("생성된 카페의 이름은 ${it.name}입니다.") }
}
