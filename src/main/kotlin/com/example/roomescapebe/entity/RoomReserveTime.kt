package com.example.roomescapebe.entity

import com.example.roomescapebe.dto.RoomReserveTimeDto
import jakarta.persistence.*
import lombok.Getter
import lombok.Setter
import java.time.LocalTime

@Getter
@Setter
@Entity
@Table(name = "room_reserve_time")
class RoomReserveTime(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val roomReserveTimeId: Int? = null,

    val reserveTime: LocalTime,

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "room_id")
    val room: Room? = null
) {
    constructor() : this(reserveTime = LocalTime.now(), room = Room())
    constructor(roomReserveTimeDto: RoomReserveTimeDto, room: Room) : this(reserveTime = roomReserveTimeDto.reserveTime, room = room)
}