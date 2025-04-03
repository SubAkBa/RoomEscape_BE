package com.example.roomescapebe.service

import com.example.roomescapebe.dto.RoomDto
import com.example.roomescapebe.dto.RoomReserveTimeDto
import com.example.roomescapebe.entity.Room
import com.example.roomescapebe.entity.RoomReserveTime
import com.example.roomescapebe.repository.RoomRepository
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
@Transactional(readOnly = true)
class RoomService(
    private val roomRepository: RoomRepository,
    private val roomReserveTimeService: RoomReserveTimeService
) {
    @Transactional
    fun createRoom(roomDto: RoomDto) {
        val saveRoom: Room = roomRepository.save(Room(roomDto))
        val roomReserveTimeList: List<RoomReserveTime> = roomDto.roomReserveTimeDtoList.map { RoomReserveTime(it, room = saveRoom) }

        roomReserveTimeService.createRoomReserveTimeList(roomReserveTimeList)
    }

    fun getRoomByRoomId(roomId: Int): RoomDto {
        val findRoom: Room = roomRepository.findRoomByRoomId(roomId) ?: return RoomDto()

        return RoomDto(findRoom, findRoom.roomReserveTimeList.map { RoomReserveTimeDto(it) })
    }

    fun getAllRoomList(): List<RoomDto> {
        val findAllRoomList: List<Room> = roomRepository.findAllRoomList()

        return findAllRoomList.map {
            val roomReserveTimeDtoList: List<RoomReserveTimeDto> = it.roomReserveTimeList.map { roomReserveTime -> RoomReserveTimeDto(roomReserveTime) }

            RoomDto(it, roomReserveTimeDtoList)
        }
    }

    @Transactional
    fun modifyRoom(roomId: Int, room: Room) {
        room.roomId = roomId

        roomRepository.save(room)
    }

    @Transactional
    fun removeRoom(roomId: Int) = roomRepository.deleteById(roomId)
}