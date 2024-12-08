package com.example.demo.controller;

import com.example.demo.dto.TrainingDto;
import com.example.demo.entity.Training;
import com.example.demo.mapper.TrainingMapper;
import com.example.demo.service.TrainingService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequiredArgsConstructor
@Slf4j
@RequestMapping("/api/training")
public class TrainingController {
    private final TrainingService trainingService;
    private final TrainingMapper trainingMapper;

    @CrossOrigin(origins = "http://localhost:300")
    @GetMapping("/getTrainingsDto")
    public ResponseEntity<List<TrainingDto>> getTrainingsDto() {
        List<TrainingDto> trainingDtoList = new ArrayList<>();
        List<Training> trainingList = trainingService.getTrainingList();
        for (Training training : trainingList) {
            trainingDtoList.add(trainingMapper.TrainingEntityToDto(training));
        }
        return new ResponseEntity<>(trainingDtoList, HttpStatus.OK);
    }





}
