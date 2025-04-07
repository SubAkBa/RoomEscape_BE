package com.example.roomescapebe.repository

import com.example.roomescapebe.entity.Member
import com.example.roomescapebe.entity.QMember.member
import com.querydsl.jpa.impl.JPAQueryFactory
import org.springframework.stereotype.Repository

@Repository
class CustomMemberRepositoryImpl(
    private val queryFactory: JPAQueryFactory
): CustomMemberRepository {
    override fun selectMemberByMemberIdAndPassword(memberId: String, password: String): Member? {
        return queryFactory.selectFrom(member)
            .where(
                member.memberId.eq(memberId),
                member.password.eq(password)
            )
            .fetchOne()
    }
}