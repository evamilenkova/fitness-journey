package com.sorsix.fitnessjourney.model

import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.Id
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