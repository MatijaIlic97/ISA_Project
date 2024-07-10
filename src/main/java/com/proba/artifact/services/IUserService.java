package com.proba.artifact.services;

import com.proba.artifact.models.UserModel;

import java.util.List;

public interface IUserService {
    List<UserModel> findAll();
    UserModel create(UserModel model);
}
