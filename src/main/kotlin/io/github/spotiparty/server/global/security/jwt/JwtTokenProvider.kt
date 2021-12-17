package io.github.spotiparty.server.global.security.jwt

import io.github.spotiparty.server.global.security.auth.AuthDetailsService
import io.github.spotiparty.server.global.security.exception.ExpiredTokenException
import io.github.spotiparty.server.global.security.exception.InvalidTokenException
import io.jsonwebtoken.Claims
import io.jsonwebtoken.ExpiredJwtException
import io.jsonwebtoken.Jwts
import io.jsonwebtoken.SignatureAlgorithm
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken
import org.springframework.security.core.Authentication
import org.springframework.security.core.userdetails.UserDetails
import org.springframework.stereotype.Component
import java.util.*
import javax.servlet.http.HttpServletRequest

@Component
class JwtTokenProvider(
    private val jwtProperties: JwtProperties,
    private val authDetailsService: AuthDetailsService
) {

    fun generateAccessToken(email: String): String {
        return generateToken(email, JwtProperties.ACCESS_KEY, jwtProperties.accessExp)
    }

    fun generateRefreshToken(email: String): String {
        return generateToken(email, JwtProperties.REFRESH_KEY, jwtProperties.refreshExp)
    }

    fun resolveToken(request: HttpServletRequest): String? {
        val bearer = request.getHeader(jwtProperties.header)
        if (bearer != null && bearer.startsWith(jwtProperties.prefix) && bearer.length > jwtProperties.prefix.length) {
            return bearer.substring(jwtProperties.prefix.length + 1)
        }
        return null
    }

    fun authentication(token: String): Authentication {
        val body = getTokenBody(token)

        val details = authDetailsService.loadUserByUsername(body.subject)

        return UsernamePasswordAuthenticationToken(details, "", details.authorities)
    }

    private fun getTokenBody(token: String): Claims {
        try {
            return Jwts.parser()
                .setSigningKey(jwtProperties.secret)
                .parseClaimsJws(token).body
        } catch (e: Exception) {
            when(e) {
                is ExpiredJwtException -> throw ExpiredTokenException.EXCEPTION
                else -> throw InvalidTokenException.EXCEPTION
            }
        }
    }

    private fun generateToken(email: String, key: String, exp: Long): String {
        return Jwts.builder()
            .setSubject(email)
            .claim("type", key)
            .signWith(SignatureAlgorithm.HS256, jwtProperties.secret)
            .setExpiration(
                Date(System.currentTimeMillis() + exp)
            )
            .setIssuedAt(Date())
            .compact()
    }

}