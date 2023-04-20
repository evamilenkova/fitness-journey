package com.sorsix.fitnessjourney.service

import com.sorsix.fitnessjourney.model.Exercise

interface ExerciseService {

    fun getExercises():List<Exercise>
    fun Exercise(id:Number):Exercise
}