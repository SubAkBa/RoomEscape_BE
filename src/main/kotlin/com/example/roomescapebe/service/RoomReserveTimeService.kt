package com.example.roomescapebe.service

import com.example.roomescapebe.entity.RoomReserveTime
import com.example.roomescapebe.repository.RoomReserveTimeRepository
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
@Transactional(readOnly = true)
class RoomReserveTimeService(
    private val roomReserveTimeRepository: RoomReserveTimeRepository
) {
    @Transactional
    fun createRoomReserveTimeList(roomReserveTimeList: List<RoomReserveTime>) {
        roomReserveTimeRepository.saveAll(roomReserveTimeList)
    }
}