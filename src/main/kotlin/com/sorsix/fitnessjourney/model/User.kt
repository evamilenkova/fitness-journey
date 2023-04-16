package com.sorsix.fitnessjourney.model

import com.sorsix.fitnessjourney.model.enums.Gender
import jakarta.persistence.*
import lombok.Data
import java.time.LocalDate
import java.util.Date


@Entity
@Table(name = "fitness_user")
@Data
data class User(
    @GeneratedValue
    @Id
    val id:Int,
    val name:String,
    val surname:String,
    var username:String,
    val password:String,
    @Enumerated(EnumType.STRING)
    val gender: Gender,
    val dateOfBirth: LocalDate,
    @OneToOne(cascade = arrayOf(CascadeType.ALL))
    val journal:Journal = Journal()
) {
    constructor() : this(0, "", "", "", "", Gender.FEMALE, LocalDate.now(), Journal())
}
