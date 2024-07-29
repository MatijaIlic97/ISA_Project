package com.proba.artifact.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;
import java.util.List;

@Entity
@Data
@Table(name="training_users")
@NoArgsConstructor
@AllArgsConstructor
public class TrainingUsers {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column
    private Integer trainingId;
    @OneToMany(mappedBy = "trainings")
    @JsonBackReference
    private List<User> users;
}
