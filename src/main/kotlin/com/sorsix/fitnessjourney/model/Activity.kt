package com.sorsix.fitnessjourney.model

import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.Id
import javax.persistence.ManyToOne


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