package com.proba.artifact.mappers;

import com.proba.artifact.entities.Training;
import com.proba.artifact.models.TrainingModel;

public class TrainingMapper {
    public static TrainingModel toModel(Training entity){
        return TrainingModel.builder()
                .id(entity.getId())
                .date(entity.getDate())
                .build();

    }
    public static Training toEntity(TrainingModel model) {
        Training training = new Training();
        training.setDate(model.getDate());
        return training;
    }
}
