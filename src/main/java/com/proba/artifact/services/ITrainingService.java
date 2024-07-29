package com.proba.artifact.services;

import com.proba.artifact.models.TrainingModel;
import com.proba.artifact.models.TrainingUsersModel;

public interface ITrainingService {
    TrainingModel create(TrainingModel trainingModel);

    TrainingUsersModel addUsers(TrainingUsersModel trainingUsersModel);
}
