package com.example.roomescapebe.entity

import com.example.roomescapebe.dto.MemberDto
import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.Id
import jakarta.persistence.Table
import lombok.Getter
import lombok.Setter

@Getter
@Setter
@Entity
@Table(name = "member")
class Member(
    @Id
    val memberId: String,

    @Column(name = "password")
    val password: String,

    @Column(name = "phone_number")
    val phoneNumber: String,

    @Column(name = "name")
    val name: String
) {
    constructor(): this("", "", "", "")
    constructor(memberDto: MemberDto) : this(memberDto.memberId, memberDto.password, memberDto.phoneNumber, memberDto.name)
}