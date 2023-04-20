package com.sorsix.fitnessjourney.service

import com.sorsix.fitnessjourney.model.Exercise
import com.sorsix.fitnessjourney.repository.ExerciseRepository
import org.springframework.stereotype.Service

@Service
class ExerciseServiceImpl(val exerciseRepository: ExerciseRepository):ExerciseService {

    override fun getExercises():List<Exercise> {
        return  this.exerciseRepository.findAll();
    }


//    fun getExercisesNamesByCategory(category: String):List<String>{
//        return  this.getExercisesByCategory(category).map { it.name }
//    }


    override fun Exercise(id:Number):Exercise{
        return this.exerciseRepository.findById(id).get();
    }
}