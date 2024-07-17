package com.proba.artifact.mappers;

import com.proba.artifact.entities.User;
import com.proba.artifact.models.RegisterUserModel;
import com.proba.artifact.models.UserModel;
import com.proba.artifact.models.UserPageModel;
import org.springframework.data.domain.Page;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class UserMapper {
    public static UserModel toModel(User entity){
            return UserModel.builder()
                    .id(entity.getId())
                    .firstName(entity.getFirstName())
                    .lastName(entity.getLastName())
                    .email(entity.getEmail())
                    .build();

    }
    public static List<UserModel> toModelList(List<User> entities){
        var list = new ArrayList<UserModel>();
        for(var entity : entities){
            list.add(toModel(entity));
        }
        return list;
    }
//    public static User toEntity(UserModel model) {
//        User user = new User();
//        user.setId(model.getId());
//        user.setFirstName(model.getFirstName());
//        user.setLastName(model.getLastName());
//        user.setEmail(model.getEmail());
//       // user.setContactNumber(model.getContactNumber());
//        return user;
//    }

    public static User toEntity(RegisterUserModel model, PasswordEncoder passwordEncoder) {
        User user = new User();
        user.setEmail(model.getEmail());
        user.setPassword(passwordEncoder.encode(model.getPassword()));
        return user;
    }

    public static User toEntity(UserModel model, PasswordEncoder passwordEncoder) {
        User user = new User();
        user.setId(model.getId());
        user.setFirstName(model.getFirstName());
        user.setLastName(model.getLastName());
        user.setEmail(model.getEmail());
//        user.setContactNumber(model.getContactNumber());
        user.setPassword(passwordEncoder.encode(model.getPassword()));
        return user;
    }

    public static UserPageModel toModelPagedList(Page<User> pageEntity) {
        return UserPageModel.builder()
                .Users(toModelList(pageEntity.getContent()))
                .totalPages(pageEntity.getTotalPages())
                .totalElements(pageEntity.getTotalElements())
                .build();
    }
}
