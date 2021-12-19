package io.github.spotiparty.server.domain.user.properties

class Apple(
    private val oAuthProperties: OAuthProperties
): OAuth() {

    override fun getClientId(): String = oAuthProperties.getAppleClient()

    override fun getClientSecret(): String = oAuthProperties.getAppleSecret()

    override fun getBaseUrl(): String = oAuthProperties.getAppleBaseUrl()

    override fun getRedirectUrl(): String = oAuthProperties.getAppleRedirectUrl()

    override fun getQueryString(): String = oAuthProperties.getAppleQueryString()

}