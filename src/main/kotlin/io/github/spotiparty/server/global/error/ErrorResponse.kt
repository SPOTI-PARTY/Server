package io.github.spotiparty.server.global.error

class ErrorResponse(
    private val status: Int,
    private val message: String
) {

    override fun toString(): String {
        return "{" +
                "\n\t\"status\": " + status +
                ",\n\t\"message\": \"" + message + '\"' +
                '}'
    }

}