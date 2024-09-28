package com.example.demo.service;


import com.example.demo.Repository.*;
import com.example.demo.entity.Distance;
import com.example.demo.entity.Runs;
import com.example.demo.entity.Training;
import com.example.demo.entity.WarmUp;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

import java.time.Duration;
import java.time.LocalDate;

@Service
@RequiredArgsConstructor
@Slf4j
public class TrainingService {
    private final TrainingRepository trainingRepository;
    private final UserRepository userRepository;
    private final UserDetailsService userDetailsService;
    private final WarmUpRepository warmUpRepository;
    private final DistanceRepository distanceRepository;
    private final RunsRepository runsRepository;

    @PreAuthorize("hasRole('USER')")
    public void saverTraining(String comment, String nameOfTraining,
                              String distance, String exercises,
                              String trot, LocalDate dateOfTrain,
                              Long trainingID, Duration durationOfRun,
                              Duration pause, Integer repetition,
                              Integer numberOfRuns){
        if (durationOfRun.isNegative()){
            throw new IllegalArgumentException("durationOfRun is invalid");
        }else if (pause.isNegative()){
            throw new IllegalArgumentException("pause is invalid");
        }

        WarmUp warmUp = WarmUp.builder()
                .trot(trot)
                .exercises(exercises)
                .build();

        Training training = Training.builder()
                .dateOfTrain(dateOfTrain)
                .nameOfTraining(nameOfTraining)
                .comment(comment)
                .build();

        Distance distances = Distance.builder()
                .distance(distance)
                .build();

        Runs runs = Runs.builder()
                .durationOfRun(durationOfRun)
                .pause(pause)
                .repetition(repetition)
                .numberOfRuns(numberOfRuns)
                .build();
        trainingRepository.save(training);
        warmUpRepository.save(warmUp);
        runsRepository.save(runs);
        distanceRepository.save(distances);


    }


}
