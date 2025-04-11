package com.example.roomescapebe.repository

import com.example.roomescapebe.entity.Member
import org.springframework.stereotype.Repository

@Repository
interface CustomMemberRepository {
    fun selectMemberByMemberIdAndPassword(memberId: String, password: String): Member?
}