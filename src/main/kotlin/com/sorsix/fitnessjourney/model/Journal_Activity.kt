package com.sorsix.fitnessjourney.model

import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.Id
import jakarta.persistence.ManyToOne
import java.util.*

@Entity
data class Journal_Activity(
    @Id
    @GeneratedValue
    val id: Int = 0,
    @ManyToOne
    val activity: Activity = Activity(),
    @ManyToOne
    val journal: Journal = Journal(),
    val duration: Number = 0
) {
    constructor() : this(0, Activity(), Journal(), 0)
}