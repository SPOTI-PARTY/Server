package io.github.spotiparty.server.domain.user.service

import io.github.spotiparty.server.domain.user.exception.InvalidTypeException
import io.github.spotiparty.server.domain.user.properties.OAuthProperties
import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*
import org.mockito.Mockito.`when`
import org.mockito.Mockito.mock

internal class QueryOAuthServiceTest {

    private val oAuthProperties: OAuthProperties = mock(OAuthProperties::class.java)

    private val queryOAuthService: QueryOAuthService = QueryOAuthService(oAuthProperties)

    @Test
    fun Google_링크() {
        //given
        val googleClient = "GCLIENT"
        val googleRedirectUrl = "GREDIRECTURL"
        val googleBaseUrl = "GBASEURL"
        val googleQueryString = "%s%s"

        //when
        `when`(oAuthProperties.getGoogleClient())
            .thenReturn(googleClient)
        `when`(oAuthProperties.getGoogleRedirectUrl())
            .thenReturn(googleRedirectUrl)
        `when`(oAuthProperties.getGoogleBaseUrl())
            .thenReturn(googleBaseUrl)
        `when`(oAuthProperties.getGoogleQueryString())
            .thenReturn(googleQueryString)

        val response = queryOAuthService.execute("GOOGLE")

        //then
        assertEquals(googleBaseUrl + String.format(googleQueryString, googleClient, googleRedirectUrl), response)

    }

    @Test
    fun Spotify_링크() {
        //given
        val spotifyClient = "SCLIENT"
        val spotifyRedirectUrl = "SREDIRECTURL"
        val spotifyBaseUrl = "SBASEURL"
        val spotifyQueryString = "%s%s"

        //when
        `when`(oAuthProperties.getSpotifyClient())
            .thenReturn(spotifyClient)
        `when`(oAuthProperties.getSpotifyRedirectUrl())
            .thenReturn(spotifyRedirectUrl)
        `when`(oAuthProperties.getSpotifyBaseUrl())
            .thenReturn(spotifyBaseUrl)
        `when`(oAuthProperties.getSpotifyQueryString())
            .thenReturn(spotifyQueryString)

        val response = queryOAuthService.execute("SPOTIFY")

        //then
        assertEquals(response, spotifyBaseUrl + String.format(spotifyQueryString, spotifyClient, spotifyRedirectUrl))

    }

    @Test
    fun Apple_링크() {
        //given
        val appleClient = "ACLIENT"
        val appleRedirectUrl = "AREDIRECTURL"
        val appleBaseUrl = "ABASEURL"
        val appleQueryString = "%s%s"

        //when
        `when`(oAuthProperties.getAppleClient())
            .thenReturn(appleClient)
        `when`(oAuthProperties.getAppleRedirectUrl())
            .thenReturn(appleRedirectUrl)
        `when`(oAuthProperties.getAppleBaseUrl())
            .thenReturn(appleBaseUrl)
        `when`(oAuthProperties.getAppleQueryString())
            .thenReturn(appleQueryString)

        val response = queryOAuthService.execute("APPLE")

        //then
        assertEquals(response, appleBaseUrl + String.format(appleQueryString, appleClient, appleRedirectUrl))
    }

    @Test
    fun 잘못된_Type() {
        //given
        val type = "LEE"

        //then
        assertThrows(InvalidTypeException::class.java) {
            queryOAuthService.execute(type)
        }

    }

}