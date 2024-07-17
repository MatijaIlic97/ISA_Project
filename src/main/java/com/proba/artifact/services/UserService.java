package com.proba.artifact.services;

import com.proba.artifact.exceptions.user.UserAlreadyExistException;
import com.proba.artifact.exceptions.user.UserException;
import com.proba.artifact.mappers.UserMapper;
import com.proba.artifact.models.UserModel;
import com.proba.artifact.models.UserPageModel;
import com.proba.artifact.repositories.IUserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService implements IUserService{
    private final IUserRepository userRepository;
    private final BCryptPasswordEncoder passwordEncoder;
    @Override
    public List<UserModel> findAll() {
        return UserMapper.toModelList(userRepository.findAll());
    }

    @Override
    public UserPageModel findPagedList(PageRequest pageRequest) {
        var result = userRepository.findAll(pageRequest);
        return UserMapper.toModelPagedList(result);
    }

    @Override
    public UserModel create(UserModel model) {
        var user = UserMapper.toEntity(model, passwordEncoder);

        var existingUser = userRepository.findByEmail(model.getEmail());

        if (existingUser.isPresent())
            throw new UserAlreadyExistException("User with email " + model.getEmail() + " already exists");

        var savedUser = userRepository.save(user);

        return UserMapper.toModel(savedUser);
    }

    @Override
    public UserModel update(UserModel model) {
        var entity = UserMapper.toEntity(model, passwordEncoder);
        try {
            var result = userRepository.save(entity);
            return UserMapper.toModel(result);
        } catch (Exception e) {
            throw new UserException(e.getMessage());
        }
    }

    @Override
    public void delete(Integer userId) {
        var entity = userRepository.findById(userId).orElseThrow(() -> new UserException("User Not Found"));
        userRepository.delete(entity);
    }
}
