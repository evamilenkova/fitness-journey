package com.sorsix.fitnessjourney.model


import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.Id
import javax.persistence.ManyToOne

@Entity
data class Food(
    @GeneratedValue
    @Id
    val id: Int = 0,
    val name: String = "",
    val calories: Number = 0,
    val portionSize: Number = 0,
    val proteins: Number = 0,
    val fats: Number = 0,
    val carbohydrates: Number = 0
) {
    constructor() : this(0, "", 0, 0, 0, 0, 0)
}