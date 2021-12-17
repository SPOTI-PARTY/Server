package io.github.spotiparty.server.global.exception

import io.github.spotiparty.server.global.error.exception.ErrorCode
import io.github.spotiparty.server.global.error.exception.PartyException

class NotFoundException private constructor(): PartyException(ErrorCode.NOT_FOUND) {

    companion object {
        val EXCEPTION = NotFoundException()
    }

}