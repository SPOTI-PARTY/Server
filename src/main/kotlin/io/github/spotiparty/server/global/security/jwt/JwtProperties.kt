package io.github.spotiparty.server.global.security.jwt

import org.springframework.boot.context.properties.ConfigurationProperties
import org.springframework.boot.context.properties.ConstructorBinding

@ConstructorBinding
@ConfigurationProperties(prefix = "jwt")
class JwtProperties(
    val prefix: String,
    val header: String,
    val secret: String,
    private val exp: Expiration
) {

    companion object {
        const val ACCESS_KEY = "access"
        const val REFRESH_KEY = "refresh"
    }

    val accessExp: Long
    get() = exp.access * 1000

    val refreshExp: Long
    get() = exp.refresh * 1000

}

class Expiration(
    val access: Long,
    val refresh: Long
)