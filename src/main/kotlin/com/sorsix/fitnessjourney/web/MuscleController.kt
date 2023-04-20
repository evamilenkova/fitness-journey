package com.sorsix.fitnessjourney.web

import com.sorsix.fitnessjourney.model.Muscle
import com.sorsix.fitnessjourney.service.MuscleService
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/muslces")
class MuscleController(val muslceService: MuscleService) {


    @GetMapping("")
    fun getMuscles():List<Muscle>{
        return this.muslceService.getMuslces();
    }

}