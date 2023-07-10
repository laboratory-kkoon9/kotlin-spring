package com.laboratorykkoon9.kotlinspring

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class CafeAdminApplication

fun main(args: Array<String>) {
    runApplication<CafeAdminApplication>(*args)
}
