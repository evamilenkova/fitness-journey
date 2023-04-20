package com.sorsix.fitnessjourney.repository;

import com.sorsix.fitnessjourney.model.Muscle;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MuscleRepository : JpaRepository<Muscle, Number> {
    fun findByName(name: String): Muscle
}