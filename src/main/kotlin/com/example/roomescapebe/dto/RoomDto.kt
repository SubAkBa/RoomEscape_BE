package com.example.roomescapebe.dto

import com.example.roomescapebe.entity.Room

data class RoomDto(
    val name: String,
    val description: String?,
    val category: String,
    val horrorLevel: Int,
    val difficultLevel: Int,
    val roomReserveTimeDtoList: List<RoomReserveTimeDto>
) {
    constructor(): this("", "", "", 0, 0, listOf())
    constructor(room: Room, roomReserveTimeDtoList: List<RoomReserveTimeDto>): this(room.name, room.description, room.category, room.horrorLevel, room.difficultLevel, roomReserveTimeDtoList)
}