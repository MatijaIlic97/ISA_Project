package com.proba.artifact.controllers;

import com.proba.artifact.models.TrainingModel;
import com.proba.artifact.services.ITrainingService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("training")
@RequiredArgsConstructor
@CrossOrigin("*")
public class TrainingController {
    private final ITrainingService trainingService;

    @PostMapping("create")
    public ResponseEntity<?> create(@RequestBody @Valid TrainingModel trainingModel, BindingResult result){
        if(result.hasErrors()){
            return new ResponseEntity<>("Neuspesno kreiran trening", HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<>(trainingService.create(trainingModel), HttpStatus.CREATED);
    }

    @GetMapping("getall")
    public List<TrainingModel> getList(){
        return trainingService.findAll();
    }
}
