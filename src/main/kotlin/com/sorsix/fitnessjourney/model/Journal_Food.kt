package com.sorsix.fitnessjourney.model

import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.Id
import jakarta.persistence.ManyToMany
import jakarta.persistence.ManyToOne
import org.hibernate.Hibernate
import java.util.Date

@Entity
data class Journal_Food(
    @Id
    @GeneratedValue
    val id: Int = 0,
    @ManyToOne
    val food: Food = Food(),
    @ManyToOne
    val journal: Journal = Journal(),
    val meal_calories: Number = 0,
    val meal_proteins: Number = 0,
    val meal_fats: Number = 0,
    val meal_carbohydrates: Number = 0,
    val date: Date = Date()
) {
    constructor() : this(0, Food(), Journal(), 0, 0, 0, 0, Date())
}