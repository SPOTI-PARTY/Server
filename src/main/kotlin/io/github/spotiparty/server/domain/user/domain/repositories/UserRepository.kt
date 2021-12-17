package io.github.spotiparty.server.domain.user.domain.repositories

import io.github.spotiparty.server.domain.user.domain.User
import org.springframework.data.repository.CrudRepository

interface UserRepository: CrudRepository<User, String> {
    fun findByEmail(id: String): User?
}