package io.github.spotiparty.server.domain.track.domain

import io.github.spotiparty.server.domain.track.domain.types.Company
import io.github.spotiparty.server.global.domain.BaseUUIDEntity
import javax.persistence.*

@Table(indexes = [Index(name = "i_track", columnList = "name, artist")])
@Entity(name = "tbl_track")
class Track(

    @Column(length = 40, nullable = false)
    val name: String,

    @Enumerated(EnumType.STRING)
    @Column(length = 40, nullable = false)
    val company: Company,

    @Column(length = 40, nullable = false)
    val trackId: String,

    @Column(nullable = false)
    val imageUrl: String,

    @Column(length = 40)
    val artist: String,

    @Column(length = 10000, nullable = true)
    val lyrics: String

): BaseUUIDEntity()