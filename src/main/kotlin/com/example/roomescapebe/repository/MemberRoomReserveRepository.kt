package com.example.roomescapebe.repository

import com.example.roomescapebe.entity.MemberRoomReserve
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface MemberRoomReserveRepository: JpaRepository<MemberRoomReserve, String>, CustomMemberRoomReserveRepository {
}