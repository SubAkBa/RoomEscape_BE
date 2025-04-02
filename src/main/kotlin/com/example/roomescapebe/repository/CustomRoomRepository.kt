package com.example.roomescapebe.repository

import com.example.roomescapebe.entity.Room
import org.springframework.stereotype.Repository

@Repository
interface CustomRoomRepository {
    fun findAllRoomList(): List<Room>
    fun findRoomByRoomId(roomId: Int): Room?
}