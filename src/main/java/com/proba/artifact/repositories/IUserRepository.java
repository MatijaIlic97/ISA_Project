package com.proba.artifact.repositories;

import com.proba.artifact.entities.Token;
import com.proba.artifact.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface IUserRepository extends JpaRepository<User,Integer> {
    Optional<User> findByEmail(String email);
}
