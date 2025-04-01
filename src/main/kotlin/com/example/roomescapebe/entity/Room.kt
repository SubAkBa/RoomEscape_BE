package com.example.roomescapebe.entity

import com.example.roomescapebe.dto.RoomDto
import jakarta.persistence.*
import lombok.Getter
import lombok.Setter

@Setter
@Getter
@Entity
@Table(name = "room")
class Room(
    val name: String,
    val description: String?,
    val category: String,
    val horrorLevel: Int,
    val difficultLevel: Int
) {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var roomId: Int? = null

    constructor() : this("", "", "", 0, 0)
    constructor(roomDto: RoomDto) : this(roomDto.name, roomDto.description, roomDto.category, roomDto.horrorLevel, roomDto.difficultLevel)
}