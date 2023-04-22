package com.sorsix.fitnessjourney.model.dtos

import lombok.Data

@Data
data class UserDto(

     val username:String,
     val password:String,
)