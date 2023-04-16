package com.sorsix.fitnessjourney.model

import com.sorsix.fitnessjourney.model.enums.Gender
import jakarta.persistence.*
import lombok.Data
import java.util.Date


@Entity
@Table(name = "fitness_user")
@Data
data class User (
    @GeneratedValue
    @Id
    val id:Int = 0,
    val name:String = "",
    val surname:String = "",
    val username:String = "",
    val password:String = "",
    @Enumerated(EnumType.STRING)
    val gender:Gender = Gender.FEMALE,
    val dateOfBirth:Date = Date(),
    @OneToOne
    val journal:Journal = Journal()
) {
    constructor() : this(0, "", "", "", "", Gender.FEMALE, Date(), Journal())
}
