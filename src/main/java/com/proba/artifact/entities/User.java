package com.proba.artifact.entities;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;

@Entity
@Table(name = "users")
@Data
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "first_name")
    private String firstName;
    @Column(name = "last_name")
    private String lastName;
//    @Column(name = "email")
//    private String email;
//    @Column(name = "belt")
//    private String belt;
//    @Column(name = "birth_date")
//    private Date dateOfBirth;
//    @Column(name = "start_date")
//    private Date startDate;
}

