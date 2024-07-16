package com.proba.artifact.models;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import lombok.Builder;
import lombok.Data;


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
//    private String belt;
//    private Date dateOfBirth;
//    private Date startDate;
}
