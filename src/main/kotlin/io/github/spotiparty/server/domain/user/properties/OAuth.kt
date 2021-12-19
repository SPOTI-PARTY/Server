package io.github.spotiparty.server.domain.user.properties

abstract class OAuth {

    abstract fun getClientId(): String

    abstract fun getClientSecret(): String

    abstract fun getBaseUrl(): String

    abstract fun getRedirectUrl(): String

    abstract fun getQueryString(): String

}