package com.proba.artifact.models;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Email;
import lombok.Builder;
import lombok.Data;

import java.util.Date;

@Data
@Builder
public class UserModel {
    private Integer id;
    @NotEmpty
    private String firstName;
    @NotEmpty
    private String lastName;
//    @Email
//    private String email;
//    private String belt;
//    private Date dateOfBirth;
//    private Date startDate;
}
