package com.sorsix.fitnessjourney.repository

import com.sorsix.fitnessjourney.model.Exercise;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ExerciseRepository : JpaRepository<Exercise, Number> {}