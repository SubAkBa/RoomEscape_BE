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
    val reserveTime: LocalTime
) {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val roomReserveTimeId: Int? = null

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "room_id")
    val room: Room = Room()

    constructor() : this(LocalTime.now())
    constructor(roomReserveTimeDto: RoomReserveTimeDto) : this(roomReserveTimeDto.reserveTime)
}