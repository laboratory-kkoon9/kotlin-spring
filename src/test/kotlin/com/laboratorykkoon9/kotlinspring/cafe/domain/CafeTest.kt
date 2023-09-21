package com.laboratorykkoon9.kotlinspring.cafe.domain

import io.kotest.core.spec.style.FeatureSpec
import io.kotest.matchers.shouldBe
import java.time.LocalTime

internal class CafeTest : FeatureSpec({
    val cafe = Cafe(
        name = "맛있는 커피가 있는 카페",
        latitude = "36",
        longitude = "35",
        mainAddress = "삼전역",
        detailAddress = "지하 2층",
        openedAt = LocalTime.of(9, 0),
        closedAt = LocalTime.of(18, 0)
    )

    feature("update") {
        scenario("파라미터에 값이 없다면 업데이트를 하지 않는다.") {
            cafe.update()

            cafe.name shouldBe "맛있는 커피가 있는 카페"
            cafe.latitude shouldBe "36"
            cafe.longitude shouldBe "35"
            cafe.mainAddress shouldBe "삼전역"
            cafe.detailAddress shouldBe "지하 2층"
            cafe.openedAt shouldBe LocalTime.of(9, 0)
            cafe.closedAt shouldBe LocalTime.of(18, 0)
        }

        scenario("파라미터에 값이 있다면 해당 프로퍼티를 업데이트한다.") {
            cafe.update(
                name = "맛없는 커피가 있는 카페"
            )

            cafe.name shouldBe "맛없는 커피가 있는 카페"
            cafe.latitude shouldBe "36"
            cafe.longitude shouldBe "35"
            cafe.mainAddress shouldBe "삼전역"
            cafe.detailAddress shouldBe "지하 2층"
            cafe.openedAt shouldBe LocalTime.of(9, 0)
            cafe.closedAt shouldBe LocalTime.of(18, 0)
        }
    }

    feature("updateStatus") {
        scenario("활성화 여부가 반대로 변경된다.") {
            cafe.updateStatus()

            cafe.activate shouldBe false
        }
    }
})
