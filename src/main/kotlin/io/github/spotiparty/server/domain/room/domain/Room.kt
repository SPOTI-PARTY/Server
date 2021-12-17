package io.github.spotiparty.server.domain.room.domain

import io.github.spotiparty.server.domain.user.domain.User
import io.github.spotiparty.server.global.domain.BaseUUIDEntity
import org.hibernate.annotations.GenericGenerator
import javax.persistence.*

@Entity(name = "tbl_room")
class Room(

    @Column(columnDefinition = "BIT(1)", nullable = false)
    val isPublic: Boolean,

    @Column(columnDefinition = "INT", nullable = false)
    val headCount: Int,

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "owner_email")
    val user: User

) : BaseUUIDEntity()