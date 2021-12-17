package io.github.spotiparty.server.domain.track.domain

import io.github.spotiparty.server.global.domain.BaseUUIDEntity
import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.Index
import javax.persistence.Table

@Table(indexes = [Index(name = "i_track", columnList = "name")])
@Entity
class Track(

    @Column(length = 40, nullable = false)
    val name: String,

    @Column(length = 40, nullable = false)
    val trackId: String

): BaseUUIDEntity()