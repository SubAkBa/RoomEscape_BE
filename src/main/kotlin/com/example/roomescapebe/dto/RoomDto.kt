package com.example.roomescapebe.dto

data class RoomDto(
    val name: String,
    val description: String?,
    val category: String,
    val horrorLevel: Int,
    val difficultLevel: Int
)
