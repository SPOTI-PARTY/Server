package io.github.spotiparty.server.domain.member.domain

import io.github.spotiparty.server.domain.room.domain.Room
import io.github.spotiparty.server.domain.user.domain.User
import io.github.spotiparty.server.global.domain.BaseUUIDEntity
import javax.persistence.Entity
import javax.persistence.FetchType
import javax.persistence.JoinColumn
import javax.persistence.ManyToOne

@Entity
class Member(

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "room_id")
    val room: Room,

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    val user: User

) : BaseUUIDEntity()