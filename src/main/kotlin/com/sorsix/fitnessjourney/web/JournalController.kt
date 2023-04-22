package com.sorsix.fitnessjourney.web

import com.sorsix.fitnessjourney.model.User
import com.sorsix.fitnessjourney.service.impl.UserServiceImpl
import org.springframework.security.core.Authentication
import org.springframework.security.core.context.SecurityContextHolder
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController


@RestController
@RequestMapping("/api/auth")
class JournalController(val userService: UserServiceImpl) {

    @GetMapping("/journal")
        fun getJournal():String{
        val auth: Authentication = SecurityContextHolder.getContext().authentication
        val userDetails: User = auth.principal as User
        print(userDetails)

            return userService.loadUserByUsername(userDetails.username).journal.toString();
        }

}