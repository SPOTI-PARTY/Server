package io.github.spotiparty.server.domain.tag.domain

import io.github.spotiparty.server.domain.room.domain.Room
import io.github.spotiparty.server.global.domain.BaseUUIDEntity
import javax.persistence.*

@Entity
class Tag(

    @Column(length = 40, nullable = false)
    val name: String,

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "room_id")
    val room: Room

) : BaseUUIDEntity()