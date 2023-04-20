package com.sorsix.fitnessjourney.service

import com.sorsix.fitnessjourney.model.Exercise
import com.sorsix.fitnessjourney.model.Muscle
import com.sorsix.fitnessjourney.repository.MuscleRepository
import org.springframework.stereotype.Service

@Service
class MuscleServiceImpl(val repository: MuscleRepository):MuscleService {

    override fun getMuslces():List<Muscle>{
        return this.repository.findAll();
    }
    override fun getMuscleById(id:Number):Muscle{
        return this.repository.findById(id).get();
    }
}