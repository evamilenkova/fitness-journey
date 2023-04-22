package com.sorsix.fitnessjourney.web

import com.sorsix.fitnessjourney.config.JwtUtils
import com.sorsix.fitnessjourney.model.User
import com.sorsix.fitnessjourney.model.dtos.UserDto
import com.sorsix.fitnessjourney.service.UserService
import org.springframework.http.HttpHeaders
import org.springframework.security.core.Authentication
import org.springframework.http.ResponseEntity
import org.springframework.security.authentication.AuthenticationManager
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken
import org.springframework.security.core.context.SecurityContextHolder
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api")
class AuthenticationController(private val authenticationManager: AuthenticationManager,
                               private val userService: UserService,
                               private val jwtUtils: JwtUtils
) {

    @PostMapping("/login")
    fun authenticate(@RequestBody req:UserDto): ResponseEntity<Any> {
        val authentication: Authentication =
            authenticationManager.authenticate(UsernamePasswordAuthenticationToken(req.username, req.password))
        SecurityContextHolder.getContext().authentication = authentication
        val userDetails: User = authentication.principal as User
        val jwtCookie = jwtUtils.generateJwtCookie(userDetails)
        return ResponseEntity.ok().header(HttpHeaders.SET_COOKIE,jwtCookie.toString()).body(jwtCookie)

//        val userDetails: User=userService.loadUserByUsername(req.username);
//        if(userDetails!=null){
//         return  ResponseEntity.ok(jwtUtils.generateJwtCookie(userDetails))
//        }
//        return ResponseEntity.status(400).body("Some error has occured")
//    }

    }

    @PostMapping("/logout")
    fun logoutUser(): ResponseEntity<*> {
        val cookie = jwtUtils.getCleanJwtCookie()
        return ResponseEntity.ok().header(HttpHeaders.SET_COOKIE, cookie.toString())
            .body<String>("You've been signed out!")
    }
}