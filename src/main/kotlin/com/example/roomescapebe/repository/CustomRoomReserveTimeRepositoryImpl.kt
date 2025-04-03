package com.example.roomescapebe.repository

import com.querydsl.jpa.impl.JPAQueryFactory
import org.springframework.stereotype.Repository

@Repository
class CustomRoomReserveTimeRepositoryImpl(
    private val queryFactory: JPAQueryFactory
): CustomRoomReserveTimeRepository {
}