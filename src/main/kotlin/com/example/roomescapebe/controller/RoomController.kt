package com.example.roomescapebe.controller

import com.example.roomescapebe.dto.RoomDto
import com.example.roomescapebe.entity.Room
import com.example.roomescapebe.service.RoomService
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PatchMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/room")
class RoomController(
    private val roomService: RoomService
) {
    @PostMapping
    fun createRoom(@RequestBody roomDto: RoomDto) {
        roomService.createRoom(Room(roomDto))
    }

    @GetMapping
    fun getAllRoomList() = roomService.getAllRoomList()

    @GetMapping("/{roomId}")
    fun getRoomByRoomId(@PathVariable roomId: Int): Room {
        return roomService.getRoomByRoomId(roomId)
    }

    @PatchMapping("/{roomId}")
    fun modifyRoom(@PathVariable roomId: Int, @RequestBody roomDto: RoomDto) {
        roomService.modifyRoom(roomId, Room(roomDto))
    }

    @DeleteMapping("/{roomId}")
    fun removeRoom(@PathVariable roomId: Int) {
        roomService.removeRoom(roomId)
    }
}