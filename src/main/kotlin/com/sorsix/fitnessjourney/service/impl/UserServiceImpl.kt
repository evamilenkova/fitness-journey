package com.sorsix.fitnessjourney.service.impl

import com.sorsix.fitnessjourney.model.User
import com.sorsix.fitnessjourney.repository.UserRepository
import com.sorsix.fitnessjourney.service.UserService
import org.springframework.security.core.userdetails.UserDetails
import org.springframework.security.core.userdetails.UserDetailsService
import org.springframework.stereotype.Service

@Service
class UserServiceImpl(val userRepository: UserRepository):UserService {

    override fun save(u: User):User{
        return  this.userRepository.save(u)
    }

    override fun loadUserByUsername(username: String): User {
        return this.userRepository.findByUsername(username);
    }


    override fun listAll():List<User>{
        return this.userRepository.findAll();
    }
    override fun update(id:Number, username:String): User {
        val u:User=this.userRepository.findById(id).get()
        if(u!=null){
            //TODO IMPLEMENT
        }
        return this.userRepository.save(u)
    }

}