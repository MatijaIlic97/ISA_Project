package com.proba.artifact.models;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import lombok.Builder;
import lombok.Data;

import java.sql.Date;


@Data
@Builder
public class UserModel {
    private Integer id;
    @NotEmpty
    private String firstName;
    @NotEmpty
    private String lastName;
    @Email
    private String email;
    @NotBlank
    private String password;
//    private Integer numberOfTrainings;
    @NotEmpty
    private String belt;
    private int height;
    private int weight;
    private Date dateOfBirth;
    private Date startDate;
    private String gender;
    private String profile;
}
