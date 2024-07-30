package com.proba.artifact.services;

import com.proba.artifact.entities.Training;
import com.proba.artifact.mappers.TrainingMapper;
import com.proba.artifact.models.TrainingModel;
import com.proba.artifact.repositories.ITrainingRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TrainingService implements ITrainingService{
    private final ITrainingRepository trainingRepository;

    public List<TrainingModel> findAll() {
        return TrainingMapper.toModelList(trainingRepository.findAll());
    }

    @Override
    public TrainingModel create(TrainingModel trainingModel) {
        var training = TrainingMapper.toEntity(trainingModel);

        var savedTraining = trainingRepository.save(training);

        return TrainingMapper.toModel(savedTraining);
    }
}
