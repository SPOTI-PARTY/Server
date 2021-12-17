package io.github.spotiparty.server.domain.room.domain.repositories

import io.github.spotiparty.server.domain.room.domain.Room
import org.springframework.data.repository.CrudRepository

interface RoomRepository: CrudRepository<Room, String> {
}