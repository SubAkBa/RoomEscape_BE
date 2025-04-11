package com.example.roomescapebe.dto

import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import java.time.LocalTime

data class MemberRoomReserveDto(
    var memberRoomReserveId: String?,
    val personCount: Int,
    val description: String,
    val memberId: String,
    var memberName: String?,
    val roomId: Int,
    var roomName: String?,
    var category: String?,
    var horrorLevel: Int?,
    var difficultLevel: Int?,
    val roomReserveTimeId: Int,
    var reserveTime: LocalTime?
) {
    constructor() : this("", 0, "", "","",  0,"", "", 0, 0, 0, LocalTime.now())
}
