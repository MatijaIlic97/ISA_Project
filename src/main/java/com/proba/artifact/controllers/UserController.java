package com.proba.artifact.controllers;

import com.proba.artifact.models.UserModel;
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

    @PostMapping("createuser")
    public boolean createUser(String firstName, String lastName){
        return true;
    }

    @PostMapping("createuserbody")
    public UserModel createUserBody(@RequestBody UserModel userModel){
        return userModel;
    }
}
