package io.github.spotiparty.server.domain.user.properties

class Spotify(
    private val oAuthProperties: OAuthProperties
): OAuth() {

    override fun getClientId(): String = oAuthProperties.getSpotifyClient()

    override fun getClientSecret(): String = oAuthProperties.getSpotifySecret()

    override fun getBaseUrl(): String = oAuthProperties.getSpotifyBaseUrl()

    override fun getRedirectUrl(): String = oAuthProperties.getSpotifyRedirectUrl()

    override fun getQueryString(): String = oAuthProperties.getSpotifyQueryString()

}