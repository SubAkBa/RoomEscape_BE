package com.example.roomescapebe.repository

import com.example.roomescapebe.entity.Room
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface RoomRepository: JpaRepository<Room, Int>, CustomRoomRepository {
}