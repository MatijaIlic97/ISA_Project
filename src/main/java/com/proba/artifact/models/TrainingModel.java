package com.proba.artifact.models;

import lombok.Builder;
import lombok.Data;

import java.sql.Date;

@Data
@Builder
public class TrainingModel {
    private Integer id;
    private Date date;

}
