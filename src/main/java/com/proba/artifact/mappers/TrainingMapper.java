package com.proba.artifact.mappers;

import com.proba.artifact.entities.Training;
import com.proba.artifact.entities.User;
import com.proba.artifact.models.TrainingModel;
import com.proba.artifact.models.UserModel;

import java.util.ArrayList;
import java.util.List;

public class TrainingMapper {
    public static TrainingModel toModel(Training entity){
        return TrainingModel.builder()
                .id(entity.getId())
                .date(entity.getDate())
                .users(UserMapper.toUserTrainingModelList(entity.getUsers()))
                .build();

    }

    public static List<TrainingModel> toModelList(List<Training> entities){
        var list = new ArrayList<TrainingModel>();
        for(var entity : entities){
            list.add(toModel(entity));
        }
        return list;
    }
    public static Training toEntity(TrainingModel model) {
        Training training = new Training();
        training.setId(model.getId());
        training.setDate(model.getDate());
        training.setUsers(UserMapper.toEntityList(model.getUsers()));
        return training;
    }
}
