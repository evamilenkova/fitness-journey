package com.sorsix.fitnessjourney.model

import jakarta.persistence.*
import java.util.Collections.emptyList

@Entity
data class Muscle (
    @GeneratedValue
    @Id
    val id:Int = 0,
    val name:String = "",
    val image:String = ""
) {
    constructor() : this(0, "", "")
}