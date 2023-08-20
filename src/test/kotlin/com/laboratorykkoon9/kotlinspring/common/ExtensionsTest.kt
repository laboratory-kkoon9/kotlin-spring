package com.laboratorykkoon9.kotlinspring.common

import io.kotest.core.spec.style.BehaviorSpec
import io.kotest.matchers.shouldBe
import io.kotest.matchers.shouldNotBe

internal class ExtensionsTest: BehaviorSpec({
    val key = "keyskeyskeyskeys"
    given("String.encrypt") {
        val password = "hello"
        `when`("hello를 암호화하면") {
            val result = password.encrypt(key)
            then("hello가 아닌 다른 값이 반환된다.") {
                result shouldNotBe password
            }
        }
    }

    given("String.decrypt") {
        val password = "hello"
        `when`("암호화한 hello를 복호화하면") {
            val encrypt = password.encrypt(key)
            val result = encrypt.decrypt(key)
            then("hello 값이 반환된다.") {
                result shouldBe password
            }
        }
    }
})
