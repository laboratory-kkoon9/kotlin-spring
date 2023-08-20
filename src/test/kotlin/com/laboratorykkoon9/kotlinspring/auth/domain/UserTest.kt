package com.laboratorykkoon9.kotlinspring.auth.domain

import io.kotest.core.spec.style.BehaviorSpec
import io.kotest.matchers.shouldNotBe

internal class UserTest : BehaviorSpec({
    given("User") {
        val nickname = "겸댕"
        val email = "cute@gmail.com"
        val password = "password123!"
        val key = "keyskeyskeyskeys"
        `when`("새로운 User 인스턴스를 만들면") {
            val user = User(nickname, email, password, key)
            then("password 값은 암호화되어 저장된다.") {
                user.password shouldNotBe password
            }
        }
    }
})
