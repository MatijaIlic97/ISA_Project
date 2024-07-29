package com.proba.artifact.services;

import com.proba.artifact.mappers.TrainingMapper;
import com.proba.artifact.models.TrainingModel;
import com.proba.artifact.models.TrainingUsersModel;
import com.proba.artifact.repositories.ITrainingRepository;
import com.proba.artifact.repositories.ITrainingUsersRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class TrainingService implements ITrainingService{
    private final ITrainingRepository trainingRepository;
    private final ITrainingUsersRepository trainingUsersRepository;
    @Override
    public TrainingModel create(TrainingModel trainingModel) {
        var training = TrainingMapper.toEntity(trainingModel);

        var savedTraining = trainingRepository.save(training);

        return TrainingMapper.toModel(savedTraining);
    }

    @Override
    public TrainingUsersModel addUsers(TrainingUsersModel trainingUsersModel) {
        var trainingUsers = TrainingMapper.toEntity(trainingUsersModel);
        var savedTrainingUsers = trainingUsersRepository.save(trainingUsers);
        return TrainingMapper.toModel(savedTrainingUsers);
    }
}
