package com.laboratorykkoon9.kotlinspring.cafe.controller.request

import java.time.LocalTime

data class CreateCafeRequest(
    val name: String,
    val latitude: String?,
    val longitude: String?,
    val mainAddress: String?,
    val detailAddress: String?,
    val openedAt: LocalTime?,
    val closedAt: LocalTime?,
)

data class UpdateCafeRequest(
    val name: String?,
    val latitude: String?,
    val longitude: String?,
    val mainAddress: String?,
    val detailAddress: String?,
    val openedAt: LocalTime?,
    val closedAt: LocalTime?,
)
