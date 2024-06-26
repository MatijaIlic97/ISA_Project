package com.proba.artifact.controllers;

import com.proba.artifact.models.UserModel;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("user")
public class UserController {
    @GetMapping("getfirstname")
    public String getFirstName(){
        return "nesto123";
    }


    @GetMapping("getlist")
    public List<String> getList(){
        return List.of("nesto3", "nesto2");
    }


    @PostMapping("createuserbody")
    public ResponseEntity<?> createUserBody(@RequestBody @Valid UserModel userModel, BindingResult result){
        if(result.hasErrors()){
            return new ResponseEntity<>("Neuspesno registrovan", HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<>(userModel, HttpStatus.CREATED);
    }
}
