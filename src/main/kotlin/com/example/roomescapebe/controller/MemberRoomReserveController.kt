package com.example.roomescapebe.controller

import com.example.roomescapebe.dto.MemberRoomReserveDto
import com.example.roomescapebe.service.MemberRoomReserveService
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/member-room-reserve")
class MemberRoomReserveController(
    val memberRoomReserveService: MemberRoomReserveService
) {

    @GetMapping("/list")
    fun getAllMemberRoomReserveList(@RequestParam memberId: String): List<MemberRoomReserveDto> {
        return memberRoomReserveService.getAllMemberRoomReserveList(memberId)
    }

    @GetMapping("/{memberRoomReserveId}")
    fun getMemberRoomReserve(@PathVariable memberRoomReserveId: String): MemberRoomReserveDto {
        return memberRoomReserveService.getMemberRoomReserve(memberRoomReserveId)
    }

    @PostMapping
    fun createMemberRoomReserve(@RequestBody memberRoomReserveDto: MemberRoomReserveDto) {
        memberRoomReserveService.createMemberRoomReserve(memberRoomReserveDto)
    }

    @DeleteMapping("/{memberRoomReserveId}")
    fun removeMemberRoomResource(@PathVariable memberRoomReserveId: String) {
        memberRoomReserveService.removeMemberRoomReserve(memberRoomReserveId)
    }
}