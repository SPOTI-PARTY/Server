package io.github.spotiparty.server.domain.user.facade

import io.github.spotiparty.server.domain.user.domain.User
import io.github.spotiparty.server.domain.user.domain.repositories.UserRepository
import io.github.spotiparty.server.global.security.auth.AuthDetails
import io.github.spotiparty.server.global.security.exception.UserNotFoundException
import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*
import org.mockito.MockedStatic
import org.mockito.Mockito.*
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken
import org.springframework.security.core.context.SecurityContext
import org.springframework.security.core.context.SecurityContextHolder
import org.springframework.security.core.context.SecurityContextImpl

internal class UserFacadeTest {

    private val userRepository = mock(UserRepository::class.java)

    private val userFacade = UserFacade(userRepository)

    @Test
    fun getCurrentUser() {
        //given
        val email = "test@eamil.com"
        val details = AuthDetails(email)
        val authentication = UsernamePasswordAuthenticationToken(details, "", details.authorities)
        val context = SecurityContextImpl(authentication)
        val user = User(email)
        
        val contextHolder: MockedStatic<SecurityContextHolder> = mockStatic(SecurityContextHolder::class.java)

        //when
        contextHolder.`when`<SecurityContext>(SecurityContextHolder::getContext)
            .thenReturn(context)
        `when`(userRepository.findByEmail(email))
            .thenReturn(user)

        //then
        assertEquals(user, userFacade.getCurrentUser())
        contextHolder.close()
    }

    @Test
    fun getCurrentUserEmail() {
        //given
        val email = "test@eamil.com"
        val details = AuthDetails(email)
        val authentication = UsernamePasswordAuthenticationToken(details, "", details.authorities)
        val context = SecurityContextImpl(authentication)

        val contextHolder: MockedStatic<SecurityContextHolder> = mockStatic(SecurityContextHolder::class.java)

        //when
        contextHolder.`when`<SecurityContext>(SecurityContextHolder::getContext)
            .thenReturn(context)

        //then
        assertEquals(email, userFacade.getCurrentUserEmail())
        contextHolder.close()
    }

    @Test
    fun 유저가_없을_때() {
        //given
        val email = "test@eamil.com"
        val details = AuthDetails(email)
        val authentication = UsernamePasswordAuthenticationToken(details, "", details.authorities)
        val context = SecurityContextImpl(authentication)

        val contextHolder: MockedStatic<SecurityContextHolder> = mockStatic(SecurityContextHolder::class.java)

        //when
        contextHolder.`when`<SecurityContext>(SecurityContextHolder::getContext)
            .thenReturn(context)

        assertThrows(UserNotFoundException::class.java) {
            userFacade.getCurrentUser()
        }
    }

}