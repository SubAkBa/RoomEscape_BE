package com.example.roomescapebe.controller

import com.example.roomescapebe.dto.MemberDto
import com.example.roomescapebe.dto.MemberLoginDto
import com.example.roomescapebe.service.MemberService
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PatchMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/member")
class MemberController(
    private val memberService: MemberService
) {
    @GetMapping("/{memberId}")
    fun existsMemberByMemberId(@PathVariable memberId: String): Boolean {
        return memberService.existsMemberById(memberId)
    }

    @PostMapping("/login")
    fun loginMember(@RequestBody memberLoginDto: MemberLoginDto): Boolean {
        return memberService.findMemberByIdAndPassword(memberLoginDto)
    }

    @PostMapping
    fun createMember(@RequestBody memberDto: MemberDto) {
        memberService.createMember(memberDto)
    }

    @PatchMapping
    fun modifyMember(@RequestBody memberDto: MemberDto) {
        memberService.modifyMember(memberDto)
    }

    @DeleteMapping("/{memberId}")
    fun removeMember(@PathVariable memberId: String) {
        memberService.removeMember(memberId)
    }
}