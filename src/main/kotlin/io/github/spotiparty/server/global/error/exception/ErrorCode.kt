package io.github.spotiparty.server.global.error.exception

import com.fasterxml.jackson.annotation.JsonFormat

@JsonFormat(shape = JsonFormat.Shape.OBJECT)
enum class ErrorCode(
    val status: Int,
    val message: String
) {

    BAD_REQUEST(400, "Bad request."),
    NOT_FOUND(404, "Not found."),

    INVALID_TYPE(400, "Invalid type."),
    USER_NOT_FOUND(404, "User not found."),


    EXPIRED_TOKEN(401, "Expired token."),
    INVALID_TOKEN(401, "Invalid token.")

}