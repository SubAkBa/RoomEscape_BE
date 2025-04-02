package com.example.roomescapebe.repository

import com.example.roomescapebe.entity.QRoom.*
import com.example.roomescapebe.entity.Room
import com.querydsl.jpa.impl.JPAQueryFactory
import org.springframework.stereotype.Repository

@Repository
class CustomRoomRepositoryImpl (
    private val queryFactory: JPAQueryFactory
): CustomRoomRepository {

    override fun findRoomByRoomId(roomId: Int): Room? {
        return queryFactory.selectFrom(room)
            .where(room.roomId.eq(roomId))
            .fetchOne()
    }

    override fun findAllRoomList(): List<Room> {
        return queryFactory.selectFrom(room)
            .fetch()
    }
}