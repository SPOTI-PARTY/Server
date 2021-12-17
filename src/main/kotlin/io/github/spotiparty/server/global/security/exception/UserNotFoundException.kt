package io.github.spotiparty.server.global.security.exception

import io.github.spotiparty.server.global.error.exception.ErrorCode
import io.github.spotiparty.server.global.error.exception.PartyException

class UserNotFoundException private constructor(): PartyException(ErrorCode.USER_NOT_FOUND) {

    companion object {
        val EXCEPTION = UserNotFoundException()
    }

}