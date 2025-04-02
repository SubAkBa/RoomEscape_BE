package com.example.roomescapebe.service

import com.example.roomescapebe.entity.Room
import com.example.roomescapebe.repository.RoomRepository
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
@Transactional(readOnly = true)
class RoomService(
    private val roomRepository: RoomRepository
) {
    @Transactional
    fun createRoom(room: Room) = roomRepository.save(room)

    fun getRoomByRoomId(roomId: Int): Room {
        return roomRepository.findRoomByRoomId(roomId) ?: Room()
    }

    fun getAllRoomList(): List<Room> {
        return roomRepository.findAllRoomList()
    }

    @Transactional
    fun modifyRoom(roomId: Int, room: Room) {
        room.roomId = roomId

        roomRepository.save(room)
    }

    @Transactional
    fun removeRoom(roomId: Int) = roomRepository.deleteById(roomId)
}