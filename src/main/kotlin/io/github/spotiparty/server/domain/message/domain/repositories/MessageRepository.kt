package io.github.spotiparty.server.domain.message.domain.repositories

import io.github.spotiparty.server.domain.message.domain.Message
import org.springframework.data.repository.CrudRepository

interface MessageRepository: CrudRepository<Message, String> {
}