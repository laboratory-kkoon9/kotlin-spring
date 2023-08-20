package com.laboratorykkoon9.kotlinspring.auth.domain

import com.laboratorykkoon9.kotlinspring.common.BaseEntity
import com.laboratorykkoon9.kotlinspring.common.encrypt
import jakarta.persistence.*

@Entity
@Table(name = "users")
class User(
    nickname: String,
    email: String,
    password: String,
    key: String,
) : BaseEntity() {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null
    var nickname: String = nickname
        private set

    var email: String = email
        private set

    var password: String = password.encrypt(key).toString()
        private set
}
