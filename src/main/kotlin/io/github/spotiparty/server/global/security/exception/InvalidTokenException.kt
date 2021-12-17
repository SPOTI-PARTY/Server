package io.github.spotiparty.server.global.security.exception

import io.github.spotiparty.server.global.error.exception.ErrorCode
import io.github.spotiparty.server.global.error.exception.PartyException

class InvalidTokenException private constructor(): PartyException(ErrorCode.INVALID_TOKEN) {

    companion object {
        val EXCEPTION = InvalidTokenException()
    }

}