package io.github.spotiparty.server.global.utils.api.exception

import io.github.spotiparty.server.global.error.exception.ErrorCode
import io.github.spotiparty.server.global.error.exception.PartyException

class OtherServerExpiredTokenException private constructor() : PartyException(ErrorCode.OTHER_SERVER_EXPIRED_TOKEN) {

    companion object {
        val EXCEPTION = OtherServerExpiredTokenException()
    }

}