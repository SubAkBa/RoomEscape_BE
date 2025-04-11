package com.example.roomescapebe.repository

import com.example.roomescapebe.entity.MemberRoomReserve
import org.springframework.stereotype.Repository

@Repository
interface CustomMemberRoomReserveRepository {
    fun selectAllMemberRoomReserveList(memberId: String): List<MemberRoomReserve>
    fun selectMemberRoomReserve(memberRoomReserveId: String): MemberRoomReserve?
}