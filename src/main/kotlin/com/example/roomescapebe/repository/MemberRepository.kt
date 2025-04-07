package com.example.roomescapebe.repository

import com.example.roomescapebe.entity.Member
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface MemberRepository: JpaRepository<Member, String>, CustomMemberRepository {
}