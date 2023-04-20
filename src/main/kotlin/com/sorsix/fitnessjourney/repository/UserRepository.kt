package com.sorsix.fitnessjourney.repository

import com.sorsix.fitnessjourney.model.User
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface UserRepository: JpaRepository<User,Number> {
    fun findByUsername(username:String):User
}