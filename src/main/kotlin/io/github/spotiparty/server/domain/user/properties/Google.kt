package io.github.spotiparty.server.domain.user.properties

class Google(
    private val oAuthProperties: OAuthProperties
): OAuth() {

    override fun getClientId(): String = oAuthProperties.getGoogleClient()

    override fun getClientSecret(): String = oAuthProperties.getGoogleSecret()

    override fun getBaseUrl(): String = oAuthProperties.getGoogleBaseUrl()

    override fun getRedirectUrl(): String = oAuthProperties.getGoogleRedirectUrl()

    override fun getQueryString(): String = oAuthProperties.getGoogleQueryString()

}