package com.example.roomescapebe.service

import com.example.roomescapebe.entity.Room
import com.example.roomescapebe.repository.RoomRepository
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class RoomService(
    private val roomRepository: RoomRepository
) {
    @Transactional
    fun createRoom(room: Room) = roomRepository.save(room)

    @Transactional(readOnly = true)
    fun getRoomByRoomId(roomId: Int): Room {
        return roomRepository.findRoomByRoomId(roomId) ?: Room()
    }
}