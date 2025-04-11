package com.example.roomescapebe.repository

import com.example.roomescapebe.entity.MemberRoomReserve
import com.example.roomescapebe.entity.QMember.member
import com.example.roomescapebe.entity.QMemberRoomReserve.memberRoomReserve
import com.example.roomescapebe.entity.QRoom.room
import com.example.roomescapebe.entity.QRoomReserveTime.roomReserveTime
import com.querydsl.jpa.impl.JPAQueryFactory

class CustomMemberRoomReserveRepositoryImpl(
    private val queryfactory: JPAQueryFactory
): CustomMemberRoomReserveRepository {
    override fun selectAllMemberRoomReserveList(memberId: String): List<MemberRoomReserve> {
        return queryfactory.selectFrom(memberRoomReserve)
            .innerJoin(memberRoomReserve.member, member).fetchJoin()
            .innerJoin(memberRoomReserve.room, room).fetchJoin()
            .innerJoin(memberRoomReserve.roomReserveTime, roomReserveTime).fetchJoin()
            .where(member.memberId.eq(memberId))
            .fetch()
    }

    override fun selectMemberRoomReserve(memberRoomReserveId: String): MemberRoomReserve? {
        return queryfactory.selectFrom(memberRoomReserve)
            .innerJoin(memberRoomReserve.member, member).fetchJoin()
            .innerJoin(memberRoomReserve.room, room).fetchJoin()
            .innerJoin(memberRoomReserve.roomReserveTime, roomReserveTime).fetchJoin()
            .where(memberRoomReserve.memberRoomReserveId.eq(memberRoomReserveId))
            .fetchOne()
    }
}