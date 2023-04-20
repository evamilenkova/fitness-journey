package com.sorsix.fitnessjourney.service

import com.sorsix.fitnessjourney.model.Muscle

interface MuscleService {

    fun getMuslces():List<Muscle>
    fun getMuscleById(id:Number):Muscle
}