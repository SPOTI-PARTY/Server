package io.github.spotiparty.server.domain.tag.domain.repositories

import io.github.spotiparty.server.domain.tag.domain.Tag
import org.springframework.data.repository.CrudRepository

interface TagRepository: CrudRepository<Tag, String> {
}