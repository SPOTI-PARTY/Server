package io.github.spotiparty.server.domain.playlist.domain

import io.github.spotiparty.server.domain.room.domain.Room
import io.github.spotiparty.server.domain.track.domain.Track
import io.github.spotiparty.server.global.domain.BaseUUIDEntity
import javax.persistence.Entity
import javax.persistence.FetchType
import javax.persistence.JoinColumn
import javax.persistence.ManyToOne

@Entity
class Playlist(

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "track_id")
    val track: Track,

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "room_id")
    val room: Room

) : BaseUUIDEntity()