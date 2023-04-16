package com.sorsix.fitnessjourney.model

import com.sorsix.fitnessjourney.model.enums.Goal
import jakarta.persistence.*

@Entity
data class Journal(
    @GeneratedValue
    @Id
    val id: Int = 0,
    val height: Int = 0,
    val weight: Int = 0,
    @Enumerated(EnumType.STRING)
    val goal: Goal = Goal.MAINTAIN
) {
    constructor() : this(0, 0, 0, Goal.MAINTAIN)
}