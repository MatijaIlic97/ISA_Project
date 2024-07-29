package com.proba.artifact.models;

import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class TrainingUsersModel {
    private Integer trainingID;
    private List<UserModel> users;
}
