package com.sorsix.fitnessjourney.service

import com.sorsix.fitnessjourney.model.User
import com.sorsix.fitnessjourney.repository.UserRepository
import org.springframework.stereotype.Service

@Service
class UserService(val userRepository: UserRepository) {

    fun save(u: User):User{
      return  this.userRepository.save(u)
    }
    fun listAll():List<User>{
        return this.userRepository.findAll();
    }
    fun update(id:Number,username:String){
        val u:User=this.userRepository.findById(id).get()
        if(u!=null){
            u.username=username
        }
        this.userRepository.save(u)

    }
}