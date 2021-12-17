package io.github.spotiparty.server.global.security.exception

import io.github.spotiparty.server.global.error.exception.ErrorCode
import io.github.spotiparty.server.global.error.exception.PartyException

class ExpiredTokenException private constructor(): PartyException(ErrorCode.EXPIRED_TOKEN) {

    companion object {
        val EXCEPTION = ExpiredTokenException()
    }

}