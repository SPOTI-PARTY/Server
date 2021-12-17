package io.github.spotiparty.server.global.config

import io.github.spotiparty.server.global.error.ExceptionHandleFilter
import io.github.spotiparty.server.global.security.jwt.JwtFilter
import io.github.spotiparty.server.global.security.jwt.JwtTokenProvider
import org.springframework.context.annotation.Configuration
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder
import org.springframework.security.crypto.password.PasswordEncoder

@Configuration
@EnableWebSecurity
class SecurityConfig(
    private val jwtTokenProvider: JwtTokenProvider,
) : WebSecurityConfigurerAdapter() {

    val exceptionHandleFilter = ExceptionHandleFilter()

    override fun configure(http: HttpSecurity) {
        http
            .formLogin().disable()
            .cors().and()
            .csrf().disable()
        http
            .authorizeRequests()
            .anyRequest().authenticated()
            .apply { FilterConfig(JwtFilter(jwtTokenProvider), exceptionHandleFilter) }
    }

}