package com.sorsix.fitnessjourney.service.impl

import com.sorsix.fitnessjourney.model.User
import com.sorsix.fitnessjourney.repository.UserRepository
import com.sorsix.fitnessjourney.service.UserService
import org.springframework.security.core.userdetails.UserDetails
import org.springframework.security.core.userdetails.UserDetailsService
import org.springframework.security.crypto.password.PasswordEncoder
import org.springframework.stereotype.Service

@Service
class UserServiceImpl(val userRepository: UserRepository,val passwordEncoder: PasswordEncoder):UserService {

    override fun save(u: User):User{
        val user:User=User(u.id,u.name,u.surname,u.username,passwordEncoder.encode(u.password),u.gender,u.dateOfBirth,u.journal,u.role)
        return  this.userRepository.save(user)
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