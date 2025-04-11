package com.example.roomescapebe.entity

import jakarta.persistence.*
import lombok.Getter
import lombok.Setter

@Setter
@Getter
@Entity
@Table(name = "member_room_reserve")
class MemberRoomReserve(
    @Id
    val memberRoomReserveId: String,
    val personCount: Int,
    val description: String,

    @JoinColumn(name = "member_id")
    @OneToOne(fetch = FetchType.LAZY)
    val member: Member,

    @JoinColumn(name = "room_id")
    @OneToOne(fetch = FetchType.LAZY)
    val room: Room,

    @JoinColumn(name = "room_reserve_time_id")
    @OneToOne(fetch = FetchType.LAZY)
    val roomReserveTime: RoomReserveTime
) {
}