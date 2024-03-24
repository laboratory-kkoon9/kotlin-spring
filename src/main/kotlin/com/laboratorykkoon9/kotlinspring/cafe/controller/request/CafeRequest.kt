package com.laboratorykkoon9.kotlinspring.cafe.controller.request

import io.swagger.v3.oas.annotations.media.Schema
import jakarta.validation.constraints.NotBlank
import jakarta.validation.constraints.NotEmpty
import java.time.LocalTime

@Schema(name = "카페 생성 Request")
data class CreateCafeRequest(
    @field:NotEmpty(message = "카페 이름은 공백일 수 없습니다.")
    @Schema(description = "카페 이름", defaultValue = "댕겸의 커피집")
    val name: String,
    @Schema(description = "카페 위도", defaultValue = "37.56667")
    val latitude: String?,
    @Schema(description = "카페 경도", defaultValue = "126.97806")
    val longitude: String?,
    @Schema(description = "카페 주소", defaultValue = "서울특별시 중구 세종대로 110 서울특별시청")
    val mainAddress: String?,
    @Schema(description = "카페 상세 주소", defaultValue = "1층")
    val detailAddress: String?,
    @Schema(description = "카페 오픈 시간", defaultValue = "09:00:00")
    val openedAt: LocalTime?,
    @Schema(description = "카페 클로즈 시간", defaultValue = "18:00:00")
    val closedAt: LocalTime?,
)

@Schema(name = "카페 수정 Request")
data class UpdateCafeRequest(
    @Schema(description = "카페 이름", defaultValue = "댕겸의 커피집")
    val name: String?,
    @Schema(description = "카페 위도", defaultValue = "37.56667")
    val latitude: String?,
    @Schema(description = "카페 경도", defaultValue = "126.97806")
    val longitude: String?,
    @Schema(description = "카페 주소", defaultValue = "서울특별시 중구 세종대로 110 서울특별시청")
    val mainAddress: String?,
    @Schema(description = "카페 상세 주소", defaultValue = "1층")
    val detailAddress: String?,
    @Schema(description = "카페 오픈 시간", defaultValue = "09:00:00")
    val openedAt: LocalTime?,
    @Schema(description = "카페 클로즈 시간", defaultValue = "18:00:00")
    val closedAt: LocalTime?,
)
