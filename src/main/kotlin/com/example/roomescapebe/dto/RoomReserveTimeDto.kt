package com.example.roomescapebe.dto

import java.time.LocalTime

data class RoomReserveTimeDto(
    val roomId: Int,
    val reserveTime: LocalTime
)
