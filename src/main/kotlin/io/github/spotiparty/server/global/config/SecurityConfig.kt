package io.github.spotiparty.server.global.config

import io.github.spotiparty.server.global.error.ExceptionHandleFilter
import org.springframework.context.annotation.Configuration
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder
import org.springframework.security.crypto.password.PasswordEncoder

@Configuration
@EnableWebSecurity
class SecurityConfig(
    private val exceptionHandleFilter: ExceptionHandleFilter = ExceptionHandleFilter()
) : WebSecurityConfigurerAdapter() {

    override fun configure(http: HttpSecurity) {
        http
            .formLogin().disable()
            .cors().and()
            .csrf().disable()
        http
            .authorizeRequests()
            .anyRequest().authenticated()
            .apply { FilterConfig(exceptionHandleFilter) }
    }

    fun passwordEncoder(): PasswordEncoder = BCryptPasswordEncoder()

}