package io.github.spotiparty.server.global.error.exception

open class PartyException(
    private val errorCode: ErrorCode
): RuntimeException() {

    val status: Int
    get() = errorCode.status

    val errorMessage: String
    get() = errorCode.message

}