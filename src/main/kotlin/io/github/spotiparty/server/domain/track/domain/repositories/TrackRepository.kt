package io.github.spotiparty.server.domain.track.domain.repositories

import io.github.spotiparty.server.domain.track.domain.Track
import org.springframework.data.repository.CrudRepository

interface TrackRepository: CrudRepository<Track, String> {
}