package com.example.roomescapebe.dto

import com.example.roomescapebe.entity.Member

data class MemberDto(
    val memberId: String,
    val password: String,
    val phoneNumber: String,
    val name: String
) {
    constructor() : this("", "", "", "")
    constructor(member: Member) : this(member.memberId, member.password, member.phoneNumber, member.name)
}