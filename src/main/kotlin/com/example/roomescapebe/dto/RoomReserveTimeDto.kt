package com.example.roomescapebe.dto

import com.example.roomescapebe.entity.RoomReserveTime
import java.time.LocalTime

data class RoomReserveTimeDto(
    val reserveTime: LocalTime
) {
    constructor(roomReserveTime: RoomReserveTime): this(roomReserveTime.reserveTime)
}