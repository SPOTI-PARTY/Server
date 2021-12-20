package io.github.spotiparty.server.global.utils.api

import feign.FeignException
import feign.Response
import feign.codec.ErrorDecoder
import io.github.spotiparty.server.global.utils.api.exception.OtherServerBadRequestException
import io.github.spotiparty.server.global.utils.api.exception.OtherServerExpiredTokenException
import io.github.spotiparty.server.global.utils.api.exception.OtherServerForbiddenException
import io.github.spotiparty.server.global.utils.api.exception.OtherServerUnauthorizedException
import java.lang.Exception

class FeignClientErrorDecoder : ErrorDecoder {

    override fun decode(methodKey: String?, response: Response?): Exception {
        if (response != null && response.status() >= 400) {
            when (response.status()) {
                401 -> throw OtherServerUnauthorizedException.EXCEPTION
                403 -> throw OtherServerForbiddenException.EXCEPTION
                419 -> throw OtherServerExpiredTokenException.EXCEPTION
                else -> throw OtherServerBadRequestException.EXCEPTION
            }
        }

        return FeignException.errorStatus(methodKey, response)
    }

}