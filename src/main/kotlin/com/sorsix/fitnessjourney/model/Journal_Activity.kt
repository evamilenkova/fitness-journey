package com.sorsix.fitnessjourney.model

import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.Id
import javax.persistence.ManyToOne
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