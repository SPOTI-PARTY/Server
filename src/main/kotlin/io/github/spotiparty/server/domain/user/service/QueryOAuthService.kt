package io.github.spotiparty.server.domain.user.service

import io.github.spotiparty.server.domain.user.exception.InvalidTypeException
import io.github.spotiparty.server.domain.user.presentation.dto.response.QueryOAuthResponse
import io.github.spotiparty.server.domain.user.properties.*
import io.github.spotiparty.server.global.domain.types.Company
import org.springframework.stereotype.Service

@Service
class QueryOAuthService(
    val oAuthProperties: OAuthProperties
) {

    fun execute(type: String): QueryOAuthResponse {
        val oauth = when (type) {
            Company.GOOGLE.name -> Google(oAuthProperties)
            Company.SPOTIFY.name -> Spotify(oAuthProperties)
            Company.APPLE.name -> Apple(oAuthProperties)
            else -> throw InvalidTypeException.EXCEPTION
        }

        return QueryOAuthResponse(
            oauth.getBaseUrl() + String.format(
                oauth.getQueryString(),
                oauth.getClientId(),
                oauth.getRedirectUrl()
            )
        )
    }

}