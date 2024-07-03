package com.proba.artifact.models;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Email;
import lombok.Data;

import java.util.Date;

@Data
public class UserModel {
    private Long id;
    @NotNull
    private String firstName;
    private String lastName;
//    @Email
//    private String email;
//    private String belt;
//    private Date dateOfBirth;
//    private Date startDate;
}
