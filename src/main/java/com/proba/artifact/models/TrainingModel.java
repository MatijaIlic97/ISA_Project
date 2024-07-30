package com.proba.artifact.models;

import lombok.Builder;
import lombok.Data;

import java.sql.Date;
import java.util.List;

@Data
@Builder
public class TrainingModel {
    private Integer id;
    private Date date;
    private List<UserTrainingModel> users;
}
