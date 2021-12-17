package io.github.spotiparty.server.global.exception

import io.github.spotiparty.server.global.error.exception.ErrorCode
import io.github.spotiparty.server.global.error.exception.PartyException

class BadRequestException private constructor(): PartyException(ErrorCode.BAD_REQUEST) {

    companion object {
        val EXCEPTION = BadRequestException()
    }

}