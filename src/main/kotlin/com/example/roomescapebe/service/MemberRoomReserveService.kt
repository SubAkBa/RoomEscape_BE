package com.example.roomescapebe.service

import com.example.roomescapebe.dto.MemberRoomReserveDto
import com.example.roomescapebe.entity.Member
import com.example.roomescapebe.entity.MemberRoomReserve
import com.example.roomescapebe.entity.Room
import com.example.roomescapebe.entity.RoomReserveTime
import com.example.roomescapebe.repository.MemberRepository
import com.example.roomescapebe.repository.MemberRoomReserveRepository
import com.example.roomescapebe.repository.RoomRepository
import com.example.roomescapebe.repository.RoomReserveTimeRepository
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import java.util.UUID

@Service
@Transactional(readOnly = true)
class MemberRoomReserveService(
    val memberRoomReserveRepository: MemberRoomReserveRepository,
    val memberRepository: MemberRepository,
    val roomRepository: RoomRepository,
    val roomReserveTimeRepository: RoomReserveTimeRepository
) {
    fun getAllMemberRoomReserveList(memberId: String): List<MemberRoomReserveDto> {
        val findAllMemberRoomReserveList = memberRoomReserveRepository.selectAllMemberRoomReserveList(memberId)

        return findAllMemberRoomReserveList.stream()
            .map {
                MemberRoomReserveDto(
                    it.memberRoomReserveId,
                    it.personCount,
                    it.description,
                    it.member.memberId,
                    it.member.name,
                    it.room.roomId!!,
                    it.room.name,
                    it.room.category,
                    it.room.horrorLevel,
                    it.room.difficultLevel,
                    it.roomReserveTime.roomReserveTimeId!!,
                    it.roomReserveTime.reserveTime
                )
            }.toList()
    }

    fun getMemberRoomReserve(memberRoomReserveId: String): MemberRoomReserveDto {
        val findMemberRoomReserve = memberRoomReserveRepository.selectMemberRoomReserve(memberRoomReserveId) ?: return MemberRoomReserveDto()

        return MemberRoomReserveDto(
            findMemberRoomReserve.memberRoomReserveId,
            findMemberRoomReserve.personCount,
            findMemberRoomReserve.description,
            findMemberRoomReserve.member.memberId,
            findMemberRoomReserve.member.name,
            findMemberRoomReserve.room.roomId!!,
            findMemberRoomReserve.room.name,
            findMemberRoomReserve.room.category,
            findMemberRoomReserve.room.horrorLevel,
            findMemberRoomReserve.room.difficultLevel,
            findMemberRoomReserve.roomReserveTime.roomReserveTimeId!!,
            findMemberRoomReserve.roomReserveTime.reserveTime
        )
    }

    @Transactional
    fun createMemberRoomReserve(memberRoomReserveDto: MemberRoomReserveDto) {
        val memberRoomReserveId: String = UUID.randomUUID().toString()

        val findMember: Member = memberRepository.findById(memberRoomReserveDto.memberId).orElse(Member())
        val findRoom: Room = roomRepository.findRoomByRoomId(memberRoomReserveDto.roomId) ?: Room()
        val findRoomReserveTime: RoomReserveTime = roomReserveTimeRepository.findById(memberRoomReserveDto.roomReserveTimeId).orElse(RoomReserveTime())

        memberRoomReserveRepository.save(
            MemberRoomReserve(
                memberRoomReserveId,
                memberRoomReserveDto.personCount,
                memberRoomReserveDto.description,
                findMember,
                findRoom,
                findRoomReserveTime
            )
        )
    }

    @Transactional
    fun removeMemberRoomReserve(memberRoomReserveId: String) {
        memberRoomReserveRepository.deleteById(memberRoomReserveId)
    }
}