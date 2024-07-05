package com.proba.artifact.mappers;

import com.proba.artifact.entities.User;
import com.proba.artifact.models.UserModel;

import java.util.ArrayList;
import java.util.List;

public class UserMapper {
    public static UserModel toModel(User entity){
        return UserModel.builder()
                .firstName(entity.getFirstName())
                .lastName(entity.getLastName())
                .build();
    }
    public static List<UserModel> toModelList(List<User> entities){
        var list = new ArrayList<UserModel>();
        for(var entity : entities){
            list.add(toModel(entity));
        }
        return list;
    }
    public static User toEntity(UserModel model){
        User user = new User();
        user.setId(model.getId());
        user.setFirstName(model.getFirstName());
        user.setLastName(model.getLastName());
        return user;
    }
}
