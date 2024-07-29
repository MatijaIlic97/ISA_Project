package com.proba.artifact.repositories;

import com.proba.artifact.entities.TrainingUsers;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ITrainingUsersRepository extends JpaRepository<TrainingUsers, Integer> {
}
