package com.sorsix.fitnessjourney.web

import com.sorsix.fitnessjourney.model.User
import com.sorsix.fitnessjourney.service.impl.UserServiceImpl
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/users")
class UserController(val userService: UserServiceImpl) {

    @GetMapping()
    fun getUsers():List<User>{
        return this.userService.listAll();
    }

    @PostMapping("/add")
    fun addUser(@RequestBody u: User){
        this.userService.save(u);
    }
    @PutMapping("/edit/{id}")
    fun editUser(@PathVariable id:Number,@RequestParam username:String){
        this.userService.update(id,username)
    }



}