package io.github.spotiparty.server.domain.user.exception

import io.github.spotiparty.server.global.error.exception.ErrorCode
import io.github.spotiparty.server.global.error.exception.PartyException

class InvalidTypeException private constructor(): PartyException(ErrorCode.INVALID_TYPE) {

    companion object {
        val EXCEPTION = InvalidTypeException()
    }

}