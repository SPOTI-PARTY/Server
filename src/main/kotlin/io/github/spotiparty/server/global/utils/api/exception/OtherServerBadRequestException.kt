package io.github.spotiparty.server.global.utils.api.exception

import io.github.spotiparty.server.global.error.exception.ErrorCode
import io.github.spotiparty.server.global.error.exception.PartyException

class OtherServerBadRequestException private constructor() : PartyException(ErrorCode.OTHER_SERVER_BAD_REQUEST) {

    companion object {
        val EXCEPTION = OtherServerBadRequestException()
    }

}