package io.github.spotiparty.server.domain.playlist.domain.repositories

import io.github.spotiparty.server.domain.playlist.domain.Playlist
import org.springframework.data.repository.CrudRepository

interface PlaylistRepository: CrudRepository<Playlist, String> {
}