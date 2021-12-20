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

    DUPLICATION_NAME(409, "Duplication name."),


    EXPIRED_TOKEN(401, "Expired token."),
    INVALID_TOKEN(401, "Invalid token."),

    OTHER_SERVER_BAD_REQUEST(400, "Other server bad request."),
    OTHER_SERVER_EXPIRED_TOKEN(419, "Other server expired token."),
    OTHER_SERVER_FORBIDDEN(403, "Other server forbidden."),
    OTHER_SERVER_UNAUTHORIZED(401, "Other server unauthorized")

}