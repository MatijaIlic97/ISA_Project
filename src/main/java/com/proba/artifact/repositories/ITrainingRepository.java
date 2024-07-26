package com.proba.artifact.repositories;

import com.proba.artifact.entities.Training;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ITrainingRepository extends JpaRepository<Training, Integer> {
}
