package io.github.spotiparty.server.domain.room.domain

import org.hibernate.annotations.GenericGenerator
import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.Id

@Entity
class Room(
    
    @Id
    @GeneratedValue(generator = "uuid2")
    @GenericGenerator(name = "uuid2", strategy = "uuid2")
    @Column(columnDefinition = "BINARY(36)")
    val uuid: String,

    @Column(columnDefinition = "BIT(1)", nullable = false)
    val isPublic: Boolean,

    @Column(columnDefinition = "INT", nullable = false)
    val headCount: Int

)