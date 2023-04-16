package com.sorsix.fitnessjourney.model

import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.Id


@Entity
data class Activity(
    @GeneratedValue
    @Id
    val id: Int = 0,
    val name: String = "",
    val caloriesPerHour: Number = 0,
) {
    constructor() : this(0, "", 0)
}