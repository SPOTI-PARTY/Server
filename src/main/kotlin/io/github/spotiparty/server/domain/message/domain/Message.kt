package io.github.spotiparty.server.domain.message.domain

import io.github.spotiparty.server.domain.member.domain.Member
import io.github.spotiparty.server.domain.room.domain.Room
import io.github.spotiparty.server.global.domain.BaseUUIDEntity
import org.springframework.data.jpa.domain.support.AuditingEntityListener
import java.time.LocalDateTime
import javax.persistence.*

@EntityListeners(AuditingEntityListener::class)
@Entity(name = "tbl_message")
class Message(

    @Column(nullable = false)
    val content: String,

    @Column(columnDefinition = "DATETIME", nullable = false)
    val sentAt: LocalDateTime,

    @ManyToOne(fetch = FetchType.LAZY, optional = true)
    @JoinColumn(name = "member_id")
    val member: Member,

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "room_id")
    val room: Room

): BaseUUIDEntity()