package com.proba.artifact.mappers;

import com.proba.artifact.entities.Training;
import com.proba.artifact.entities.User;
import com.proba.artifact.models.RegisterUserModel;
import com.proba.artifact.models.TrainingModel;
import com.proba.artifact.models.UserModel;
import org.springframework.security.crypto.password.PasswordEncoder;

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
