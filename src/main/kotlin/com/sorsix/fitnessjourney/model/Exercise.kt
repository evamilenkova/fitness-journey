package com.sorsix.fitnessjourney.model

import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.Id
import jakarta.persistence.ManyToMany
import java.util.Collections.emptyList

@Entity
data class Exercise(
    @GeneratedValue
    @Id
    val id:Int = 0,
    val name:String = "",
    val category:String = "",
    val force:String = "",
    val steps: String = "",
    val video_url:String = "",
    @ManyToMany(mappedBy = "exercises")
    val muslces:List<Muscle> = emptyList()
) {
    constructor() : this(0, "", "", "", "", "", emptyList())
}
