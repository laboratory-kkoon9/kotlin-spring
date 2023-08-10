package com.laboratorykkoon9.kotlinspring.cafe.service

import com.laboratorykkoon9.kotlinspring.cafe.repository.CafeRepository
import com.laboratorykkoon9.kotlinspring.cafe.service.model.CreateCafeDto
import com.laboratorykkoon9.kotlinspring.cafe.service.model.GetCafeInfo
import com.laboratorykkoon9.kotlinspring.cafe.service.model.UpdateCafeDto
import mu.KotlinLogging
import org.springframework.data.domain.Pageable
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class CafeService(
    private val cafeRepository: CafeRepository
) {
    val logger = KotlinLogging.logger {}

    @Transactional(readOnly = true)
    suspend fun getCafeInfo(
        pageable: Pageable
    ) = cafeRepository.findAll(pageable)
        .also { logger.info("조회된 카페의 개수는 ${it.content.size}입니다.") }
        .map { GetCafeInfo.of(it) }

    @Transactional
    suspend fun createCafe(
        cafeDto: CreateCafeDto
    ) = cafeDto.toEntity()
        .also {
            val cafe = cafeRepository.findByName(it.name)
            if (cafe.isPresent) {
                throw IllegalArgumentException("${it.name}은(는) 이미 존재하는 이름입니다.")
            }
        }
        .also { cafeRepository.save(it) }
        .also { logger.info("생성된 카페의 이름은 ${it.name}입니다.") }

    @Transactional
    suspend fun updateCafe(
        cafeDto: UpdateCafeDto
    ) = cafeDto.let {
        cafeRepository.findById(it.id).orElseThrow { IllegalArgumentException("카페 번호를 다시 확인해주세요.") }
    }
        .also {
            it.update(
                name = cafeDto.name,
                latitude = cafeDto.latitude,
                longitude = cafeDto.longitude,
                mainAddress = cafeDto.mainAddress,
                detailAddress = cafeDto.detailAddress,
                openedAt = cafeDto.openedAt,
                closedAt = cafeDto.closedAt,
            )
        }
        .also { logger.info("수정된 카페의 이름은 ${it.name}입니다.") }

    @Transactional
    suspend fun updateCafeStatus(
        id: Long
    ) = cafeRepository.findById(id).orElseThrow { IllegalArgumentException("카페 번호를 다시 확인해주세요.") }
        .also {
            it.updateStatus()
        }
        .also { logger.info("이 카페는 ${if(it.activate) "활성화" else "비활성화"}되었습니다.") }
}
