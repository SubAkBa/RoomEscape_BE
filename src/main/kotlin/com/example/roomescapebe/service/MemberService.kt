package com.example.roomescapebe.service

import com.example.roomescapebe.dto.MemberDto
import com.example.roomescapebe.dto.MemberLoginDto
import com.example.roomescapebe.entity.Member
import com.example.roomescapebe.repository.MemberRepository
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import java.util.*

@Service
@Transactional(readOnly = true)
class MemberService(
    private val memberRepository: MemberRepository
) {
    fun existsMemberById(memberId: String): Boolean {
        val findMember = memberRepository.findById(memberId)

        return findMember.isPresent
    }

    fun findMemberByIdAndPassword(memberLoginDto: MemberLoginDto): Boolean {
        val findMember: Member? = memberRepository.selectMemberByMemberIdAndPassword(memberLoginDto.memberId, memberLoginDto.password)

        return Objects.nonNull(findMember)
    }

    @Transactional
    fun createMember(memberDto: MemberDto) {
        memberRepository.save(Member(memberDto))
    }

    @Transactional
    fun modifyMember(memberDto: MemberDto) {
        memberRepository.save(Member(memberDto))
    }

    @Transactional
    fun removeMember(memberId: String) {
        memberRepository.deleteById(memberId)
    }
}