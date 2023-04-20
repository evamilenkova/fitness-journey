package com.sorsix.fitnessjourney.web

import com.sorsix.fitnessjourney.model.Exercise
import com.sorsix.fitnessjourney.service.ExerciseService
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/exercise")
class ExerciseController(val exerciseService: ExerciseService) {


    @GetMapping("")
    fun getExercises():List<Exercise>{
        return this.exerciseService.getExercises();
    }
//    @GetMapping("/category")
//    fun getExercisesNamesByCategory(@RequestParam category: String):List<String>{
//        //return  this.exerciseService.getExercisesNamesByCategory(category)
//    }
}