package com.sorsix.fitnessjourney.config

import org.springframework.http.HttpHeaders.AUTHORIZATION
import org.springframework.security.core.context.SecurityContextHolder
import org.springframework.security.core.userdetails.UserDetails
import org.springframework.web.filter.OncePerRequestFilter
import javax.servlet.FilterChain
import javax.servlet.http.HttpServletRequest
import javax.servlet.http.HttpServletResponse

class JwtAthFilter: OncePerRequestFilter() {
    override fun doFilterInternal(
        request: HttpServletRequest,
        response: HttpServletResponse,
        filterChain: FilterChain
    ) {
        val authHeader:String=request.getHeader(AUTHORIZATION)
        val username:String
        val jwtToken:String

        if(authHeader==null || !authHeader.startsWith("Bearer"))
        {
            filterChain.doFilter(request,response)
            return;
        }
        jwtToken=authHeader.substring(7)
        username="something" //TODO
        if (username!=null && SecurityContextHolder.getContext().authentication==null){

        }
    }
}