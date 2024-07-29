package com.proba.artifact.mappers;

import com.proba.artifact.entities.Training;
import com.proba.artifact.entities.TrainingUsers;
import com.proba.artifact.models.TrainingModel;
import com.proba.artifact.models.TrainingUsersModel;

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

    public static TrainingUsersModel toModel(TrainingUsers entity){
        return TrainingUsersModel.builder()
                .trainingID(entity.getTrainingId())
                .users(UserMapper.toModelList(entity.getUsers()))
                .build();
    }

    public static TrainingUsers toEntity(TrainingUsersModel model){
        TrainingUsers trainingUsers = new TrainingUsers();
        trainingUsers.setTrainingId(model.getTrainingID());
        trainingUsers.setUsers(UserMapper.toEntityList(model.getUsers()));
        return trainingUsers;
    }
}
