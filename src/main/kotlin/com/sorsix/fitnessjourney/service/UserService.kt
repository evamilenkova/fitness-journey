package com.sorsix.fitnessjourney.service

import org.springframework.security.core.userdetails.User
import org.springframework.security.core.userdetails.UserDetailsService

interface UserService:UserDetailsService {
    override fun loadUserByUsername(username: String): com.sorsix.fitnessjourney.model.User
    fun save(u:com.sorsix.fitnessjourney.model.User):com.sorsix.fitnessjourney.model.User
    fun listAll():List<com.sorsix.fitnessjourney.model.User>
    fun update(id:Number,username:String):com.sorsix.fitnessjourney.model.User




}