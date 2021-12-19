package io.github.spotiparty.server.domain.user.properties

import org.springframework.boot.context.properties.ConfigurationProperties
import org.springframework.boot.context.properties.ConstructorBinding

@ConstructorBinding
@ConfigurationProperties(prefix = "oauth")
class OAuthProperties(
    val google: OAuth,
    val spotify: OAuth,
    val apple: OAuth
) {

    fun getGoogleClient() = google.clientId
    fun getGoogleSecret() = google.clientSecret
    fun getGoogleBaseUrl() = google.baseUrl
    fun getGoogleRedirectUrl() = google.redirectUrl
    fun getGoogleQueryString() = google.queryString

    fun getSpotifyClient() = spotify.clientId
    fun getSpotifySecret() = spotify.clientSecret
    fun getSpotifyBaseUrl() = spotify.baseUrl
    fun getSpotifyRedirectUrl() = spotify.redirectUrl
    fun getSpotifyQueryString() = spotify.queryString

    fun getAppleClient() = apple.clientId
    fun getAppleSecret() = apple.clientSecret
    fun getAppleBaseUrl() = apple.baseUrl
    fun getAppleRedirectUrl() = apple.redirectUrl
    fun getAppleQueryString() = apple.queryString



    class OAuth(
        val clientId: String,
        val clientSecret: String,
        val baseUrl: String,
        val redirectUrl: String,
        val queryString: String
    )

}