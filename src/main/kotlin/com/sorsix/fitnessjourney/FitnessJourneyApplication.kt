package com.sorsix.fitnessjourney

import com.sorsix.fitnessjourney.repository.ExerciseRepository
import com.sorsix.fitnessjourney.repository.MuscleRepository
import com.sorsix.fitnessjourney.util.fetchExercisesFromRapidApi
import fetchMusclesFromRapidApi
import jakarta.annotation.PostConstruct

//import jakarta.annotation.PostConstruct
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class FitnessJourneyApplication(private val muscleRepository: MuscleRepository, private val exerciseRepository: ExerciseRepository) {
    //za da povika funkcija za fetch pri run
    @PostConstruct
    fun fetchData() {
        fetchMusclesFromRapidApi(muscleRepository);
        fetchExercisesFromRapidApi(muscleRepository, exerciseRepository);
    }
}

fun main(args: Array<String>) {
    runApplication<FitnessJourneyApplication>(*args)
}
