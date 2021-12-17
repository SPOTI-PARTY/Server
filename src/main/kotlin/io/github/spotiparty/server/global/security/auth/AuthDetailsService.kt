package io.github.spotiparty.server.global.security.auth

import io.github.spotiparty.server.domain.user.domain.User
import io.github.spotiparty.server.domain.user.domain.repositories.UserRepository
import io.github.spotiparty.server.global.security.exception.UserNotFoundException
import org.springframework.security.core.userdetails.UserDetails
import org.springframework.security.core.userdetails.UserDetailsService
import org.springframework.stereotype.Service

@Service
class AuthDetailsService(
    private val userRepository: UserRepository
): UserDetailsService {

    override fun loadUserByUsername(username: String?): UserDetails? {
        val user: User = userRepository.findByEmail(username!!)?: throw UserNotFoundException.EXCEPTION
        return AuthDetails(user.email)
    }

}