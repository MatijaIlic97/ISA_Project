package com.proba.artifact.models;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import lombok.Builder;
import lombok.Data;

import java.sql.Date;

@Data
@Builder
public class UserProfileModel {
    private Integer id;
    @NotEmpty
    private String firstName;
    @NotEmpty
    private String lastName;
    @Email
    private String email;
    @NotBlank
    private String password;
    private String belt;
    @NotEmpty
    private int height;
    @NotEmpty
    private int weight;
    private Date dateOfBirth;
    private Date startDate;
    private String gender;
    private Integer numberOfTrainings;
}
