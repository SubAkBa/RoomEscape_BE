package com.example.roomescapebe.repository

import com.example.roomescapebe.entity.QRoom.*
import com.example.roomescapebe.entity.QRoomReserveTime.*
import com.example.roomescapebe.entity.Room
import com.querydsl.jpa.impl.JPAQueryFactory
import org.springframework.stereotype.Repository

@Repository
class CustomRoomRepositoryImpl (
    private val queryFactory: JPAQueryFactory
): CustomRoomRepository {

    override fun findRoomByRoomId(roomId: Int): Room? {
        return queryFactory.selectFrom(room)
            .innerJoin(roomReserveTime).on(room.roomId.eq(roomReserveTime.room.roomId)).fetchJoin()
            .where(room.roomId.eq(roomId))
            .fetchOne()
    }

    override fun findAllRoomList(): List<Room> {
        return queryFactory.selectFrom(room)
            .innerJoin(roomReserveTime).on(room.roomId.eq(roomReserveTime.room.roomId)).fetchJoin()
            .fetch()
    }
}