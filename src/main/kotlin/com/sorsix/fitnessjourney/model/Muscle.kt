package com.sorsix.fitnessjourney.model

import jakarta.persistence.*
import java.util.Collections.emptyList

@Entity
data class Muscle (
    @GeneratedValue
    @Id
    val id:Int = 0,
    val name:String = "",
    val image:String = "",
    @ManyToMany
    @JoinTable(
        name = "Exercises_Muscle",
        joinColumns = [JoinColumn(name = "MUSCLE_ID", referencedColumnName = "ID")],
        inverseJoinColumns = [JoinColumn(name = "EXERCISE_ID", referencedColumnName = "ID")]
    )
    val exercises:List<Exercise> = emptyList()
) {
    constructor() : this(0, "", "")
}