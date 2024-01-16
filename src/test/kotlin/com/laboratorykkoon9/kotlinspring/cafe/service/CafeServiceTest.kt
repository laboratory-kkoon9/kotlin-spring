package com.laboratorykkoon9.kotlinspring.cafe.service

import com.laboratorykkoon9.kotlinspring.cafe.repository.CafeRepository
import com.laboratorykkoon9.kotlinspring.cafe.service.model.CreateCafeDto
import com.laboratorykkoon9.kotlinspring.cafe.service.model.UpdateCafeDto
import com.laboratorykkoon9.kotlinspring.config.QuerydslConfig
import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.DescribeSpec
import io.kotest.matchers.shouldBe
import io.mockk.every
import io.mockk.just
import io.mockk.mockk
import io.mockk.runs
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest
import org.springframework.context.annotation.Import
import org.springframework.core.io.ClassPathResource
import org.springframework.data.domain.Pageable
import org.springframework.jdbc.datasource.init.ScriptUtils
import java.sql.SQLException
import javax.sql.DataSource

@DataJpaTest
@Import(QuerydslConfig::class)
@AutoConfigureTestDatabase(
    replace = AutoConfigureTestDatabase.Replace.NONE,
)
internal class CafeServiceTest(
    @Autowired private val cafeRepository: CafeRepository,
    @Autowired private val dataSource: DataSource,
): DescribeSpec({
    beforeSpec {
        try {
            dataSource.connection.use {conn ->
                ScriptUtils.executeSqlScript(
                    conn,
                    ClassPathResource("/sql/cafe.sql")
                )
            }
        } catch (e: SQLException) {
            throw RuntimeException(e)
        }
    }

    val cafeValidator = mockk<CafeValidator>()
    val cafeService = CafeService(
        cafeRepository = cafeRepository,
        cafeValidator = cafeValidator
    )

    describe("getCafeInfo") {
        context("모든 카페를 조회하면") {
            val cafe = cafeService.getCafeInfo(Pageable.ofSize(1))
            it("개수는 1개가 나온다.") {
                cafe.content.size shouldBe 1
            }
        }
    }

    describe("createCafe") {
        context("이미 존재하는 카페 이름으로 생성을 시도하면") {
            val cafeDto = CreateCafeDto(
                name = "둥겸의 커피집"
            )
            every { cafeValidator.createValidator(any()) } throws IllegalArgumentException()

            it("예외를 던진다.") {
                shouldThrow<IllegalArgumentException> {
                    cafeService.createCafe(cafeDto)
                }
            }
        }

        context("존재하지 않은 카페 이름으로 생성을 시도하면") {
            val cafeDto = CreateCafeDto(
                name = "둥겸의 커피집1"
            )
            every { cafeValidator.createValidator(any()) } just runs

            it("카페 정보가 잘 저장된다.") {
                val cafe = cafeService.createCafe(cafeDto)
                cafe.name shouldBe "둥겸의 커피집1"
            }
        }
    }

    describe("updateCafe") {
        context("존재하지 않는 카페 id로 수정을 시도하면") {
            val cafeDto = UpdateCafeDto(
                id = -1,
                name = "둥겸의 커피집"
            )

            it("예외를 던진다.") {
                shouldThrow<IllegalArgumentException> {
                    cafeService.updateCafe(cafeDto)
                }
            }
        }

        context("존재하지 않는 카페 id로 카페 상태를 수정을 시도하면") {
            val cafeId = -1L

            it("예외를 던진다.") {
                shouldThrow<IllegalArgumentException> {
                    cafeService.updateCafeStatus(cafeId)
                }
            }
        }

        context("카페 상태를 수정을 시도하면") {
            val cafeId = 1L

            it("카페 상태가 수정된다.") {
                val cafe = cafeService.updateCafeStatus(cafeId)
                cafe.activate shouldBe false
            }
        }
    }
})