package com.proba.artifact.services;

import com.proba.artifact.mappers.UserMapper;
import com.proba.artifact.models.UserModel;
import com.proba.artifact.repositories.IUserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService implements IUserService{
    private final IUserRepository userRepository;
    @Override
    public List<UserModel> findAll() {
        return UserMapper.toModelList(userRepository.findAll());
    }

    @Override
    public UserModel create(UserModel model) {
        var entity = UserMapper.toEntity(model);
        var result = userRepository.save(entity);
        return UserMapper.toModel(result);
    }
}
