package io.github.spotiparty.server.domain.user.presentation

import io.github.spotiparty.server.domain.user.presentation.dto.response.QueryOAuthResponse
import io.github.spotiparty.server.domain.user.service.QueryOAuthService
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestParam

class UserController(
    private val queryOAuthService: QueryOAuthService
) {

    @GetMapping("/oauth")
    fun queryOAuthLink(@RequestParam("type") type: String): QueryOAuthResponse = queryOAuthService.execute(type)

}