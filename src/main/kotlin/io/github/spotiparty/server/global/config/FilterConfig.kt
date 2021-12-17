package io.github.spotiparty.server.global.config

import io.github.spotiparty.server.global.error.ExceptionHandleFilter
import io.github.spotiparty.server.global.security.jwt.JwtFilter
import org.springframework.security.config.annotation.SecurityConfigurerAdapter
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.web.DefaultSecurityFilterChain
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter

class FilterConfig(
    private val jwtFilter: JwtFilter,
    private val exceptionHandleFilter: ExceptionHandleFilter
) : SecurityConfigurerAdapter<DefaultSecurityFilterChain, HttpSecurity>() {

    override fun configure(builder: HttpSecurity) {
        builder
            .addFilterBefore(jwtFilter, UsernamePasswordAuthenticationFilter::class.java)
            .addFilterBefore(exceptionHandleFilter, JwtFilter::class.java)
    }

}