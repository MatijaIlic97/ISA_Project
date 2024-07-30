package com.proba.artifact.services;

import com.proba.artifact.entities.Training;
import com.proba.artifact.models.TrainingModel;

import java.util.List;

public interface ITrainingService {
    TrainingModel create(TrainingModel trainingModel);
    List<TrainingModel> findAll();
}
