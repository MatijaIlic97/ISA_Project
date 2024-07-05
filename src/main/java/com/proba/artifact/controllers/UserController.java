package com.proba.artifact.controllers;

import com.proba.artifact.entities.User;
import com.proba.artifact.mappers.UserMapper;
import com.proba.artifact.models.UserModel;
import com.proba.artifact.repositories.IUserRepository;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("user")
@RequiredArgsConstructor
public class UserController {
    private final IUserRepository userRepository;
    @CrossOrigin("*")
    @GetMapping("getfirstname")
    public Optional<User> getFirstName(){
        var result = userRepository.findById(1);
        return result;
    }


    @GetMapping("getlist")
    public List<UserModel> getList(){
        return UserMapper.toModelList(userRepository.findAll());
    }


    @PostMapping("createuserbody")
    public ResponseEntity<?> createUserBody(@RequestBody @Valid UserModel userModel, BindingResult result){
        if(result.hasErrors()){
            return new ResponseEntity<>("Neuspesno registrovan", HttpStatus.INTERNAL_SERVER_ERROR);
        }
        var entity = UserMapper.toEntity(userModel);
        userRepository.save(entity);
        return new ResponseEntity<>(userModel, HttpStatus.CREATED);
    }
}
