package com.proba.artifact.services;

import com.proba.artifact.mappers.TrainingMapper;
import com.proba.artifact.models.TrainingModel;
import com.proba.artifact.repositories.ITrainingRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class TrainingService implements ITrainingService{
    private final ITrainingRepository trainingRepository;
    @Override
    public TrainingModel create(TrainingModel trainingModel) {
        var training = TrainingMapper.toEntity(trainingModel);

        var savedTraining = trainingRepository.save(training);

        return TrainingMapper.toModel(savedTraining);
    }
}
