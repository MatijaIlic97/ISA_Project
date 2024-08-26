package com.proba.artifact.controllers;

import com.proba.artifact.models.UserModel;
import com.proba.artifact.models.UserPageModel;
import com.proba.artifact.models.UserProfileModel;
import com.proba.artifact.services.IUserService;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("user")
@RequiredArgsConstructor
@CrossOrigin("*")
public class UserController {
    private final IUserService userService;

    @GetMapping("profile")
    public UserProfileModel getProfile(Integer id) {return userService.findProfileById(id);}

    @GetMapping("getlist")
    public List<UserModel> getList(){
        return userService.findAll();
    }

    @GetMapping("get-page-list")
    public UserPageModel getPageList(Integer pageNumber, Integer pageSize) {
        return userService.findPagedList(PageRequest.of(pageNumber, pageSize));
    }

    @PostMapping("create")
    public ResponseEntity<?> create(@RequestBody @Valid UserModel userModel, BindingResult result){
        if(result.hasErrors()){
            return new ResponseEntity<>("Neuspesno registrovan", HttpStatus.INTERNAL_SERVER_ERROR);
        }

        return new ResponseEntity<>(userService.create(userModel), HttpStatus.CREATED);
    }

    @PutMapping("update")
    public ResponseEntity<?> update(@RequestBody @Valid UserModel userModel, BindingResult result) {
        if (result.hasErrors()) {
            return new ResponseEntity<>("Not updated!", HttpStatus.INTERNAL_SERVER_ERROR);
        }

        return ResponseEntity.ok(userService.update(userModel));
    }

    @DeleteMapping("delete")
    public ResponseEntity<?> delete(Integer userId) {
        userService.delete(userId);
        return ResponseEntity.ok("");
    }
}
