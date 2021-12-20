package io.github.spotiparty.server.domain.user.facade

import io.github.spotiparty.server.domain.user.domain.User
import io.github.spotiparty.server.domain.user.domain.repositories.UserRepository
import io.github.spotiparty.server.global.security.exception.UserNotFoundException
import org.springframework.security.core.context.SecurityContextHolder
import org.springframework.stereotype.Component

@Component
class UserFacade(
    private val userRepository: UserRepository
) {

    fun getCurrentUser(): User {
        return userRepository.findByEmail(getCurrentUserEmail()) ?: throw UserNotFoundException.EXCEPTION
    }

    fun getCurrentUserEmail(): String = SecurityContextHolder.getContext().authentication.name

}