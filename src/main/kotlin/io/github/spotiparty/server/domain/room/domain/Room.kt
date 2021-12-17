package io.github.spotiparty.server.domain.room.domain

import io.github.spotiparty.server.global.domain.BaseUUIDEntity
import org.hibernate.annotations.GenericGenerator
import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.Id

@Entity(name = "tbl_room")
class Room(

    @Column(columnDefinition = "BIT(1)", nullable = false)
    val isPublic: Boolean,

    @Column(columnDefinition = "INT", nullable = false)
    val headCount: Int

) : BaseUUIDEntity()