package io.github.spotiparty.server.global.utils.api.exception

import io.github.spotiparty.server.global.error.exception.ErrorCode
import io.github.spotiparty.server.global.error.exception.PartyException

class OtherServerUnauthorizedException private constructor(): PartyException(ErrorCode.OTHER_SERVER_UNAUTHORIZED) {

    companion object {
        val EXCEPTION = OtherServerUnauthorizedException()
    }

}