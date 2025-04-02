package com.example.roomescapebe.repository

import com.example.roomescapebe.entity.RoomReserveTime
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface RoomReserveTimeRepository: JpaRepository<RoomReserveTime, Int>, CustomRoomReserveTimeRepository {
}