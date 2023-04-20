package com.sorsix.fitnessjourney.model


import java.util.Collections.emptyList
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.Id
import javax.persistence.ManyToOne

@Entity
data class Exercise(
    @GeneratedValue
    @Id
    val id: Int = 0,
    val name:String = "",
    val category:String = "",
    val force:String = "",
    val steps: Array<String> = emptyArray(),
    val videos:Array<String> = emptyArray(),
    @ManyToOne
    val muscle: Muscle = Muscle()
) {
    constructor(name: String, category: String, force: String, steps: Array<String>, videos: Array<String>, muscle: Muscle)
            : this(0, name, category, force, steps, videos, muscle)
}
