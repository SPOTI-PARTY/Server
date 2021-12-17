package io.github.spotiparty.server.global.error

import io.github.spotiparty.server.global.error.exception.PartyException
import org.springframework.web.filter.OncePerRequestFilter
import javax.servlet.FilterChain
import javax.servlet.http.HttpServletRequest
import javax.servlet.http.HttpServletResponse


class ExceptionHandleFilter : OncePerRequestFilter() {

    override fun doFilterInternal(
        request: HttpServletRequest,
        response: HttpServletResponse,
        filterChain: FilterChain
    ) {
        try {
            filterChain.doFilter(request, response)
        } catch (e: PartyException) {
            val errorResponse = ErrorResponse(
                status = e.status,
                message = e.errorMessage
            )

            response.contentType = "application/json"
            response.status = e.status
            response.writer.write(errorResponse.toString())
        }
    }

}