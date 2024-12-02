package com.example.demo.mapper;

import com.example.demo.dto.TrainingDto;
import com.example.demo.dto.TrainingForUser;
import com.example.demo.entity.*;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class TrainingMapper {
    public TrainingDto TrainingEntityToDto(Training training) {
        TrainingDto trainingDto = TrainingDto.builder()
                .trainingID(training.getTrainingID())
                .nameOfTraining(training.getNameOfTraining())
                .dateOfTrain(training.getDateOfTrain())
                .comment(training.getComment())
                .userfirstname(training.getUser().getFirstname())
                .userlastname(training.getUser().getLastname())
                .build();
    return trainingDto;
    }
    public TrainingForUser TrainingForUserDto(Training training) {
        WarmUp warmUp = training.getWarmUp();
        Runs runs = training.getRuns();

        TrainingForUser trainingForUser = TrainingForUser.builder()
                .trainingID(training.getTrainingID())
                .runsId(runs.getRunsId())
                .warmUpID(warmUp.getWarmUpID())
                .trot(warmUp.getTrot())
                .nameOfTraining(training.getNameOfTraining())
                .dateOfTrain(training.getDateOfTrain())
                .comment(training.getComment())
                .exercises(warmUp.getExercises())
                .dateOfTrain(training.getDateOfTrain())
                .nameOfTraining(training.getNameOfTraining())
                .comment(training.getComment())
                .durationOfRun(runs.getDurationOfRun())
                .pause(runs.getPause())
                .repetition(runs.getRepetition())
                .build();


        return trainingForUser;
    }
    public TrainingForUser trainingForCoachDto(Training training) {

        WarmUp warmUp = training.getWarmUp();
        Runs runs = training.getRuns();

        TrainingForUser trainingForUser = TrainingForUser.builder()
                .trainingID(training.getTrainingID())
                .runsId(runs.getRunsId())
                .warmUpID(warmUp.getWarmUpID())
                .trot(warmUp.getTrot())
                .nameOfTraining(training.getNameOfTraining())
                .dateOfTrain(training.getDateOfTrain())
                .comment(training.getComment())
                .exercises(warmUp.getExercises())
                .dateOfTrain(training.getDateOfTrain())
                .nameOfTraining(training.getNameOfTraining())
                .comment(training.getComment())
                .durationOfRun(runs.getDurationOfRun())
                .pause(runs.getPause())
                .repetition(runs.getRepetition())
                .days(training.getDays())
                .build();

        return trainingForUser;

    }
    public TrainingForUser trainingForAdmin(Training training){

        WarmUp warmUp = training.getWarmUp();
        Runs runs = training.getRuns();

        TrainingForUser trainingForUser = TrainingForUser.builder()
                .trainingID(training.getTrainingID())
                .runsId(runs.getRunsId())
                .warmUpID(warmUp.getWarmUpID())
                .trot(warmUp.getTrot())
                .nameOfTraining(training.getNameOfTraining())
                .dateOfTrain(training.getDateOfTrain())
                .comment(training.getComment())
                .exercises(warmUp.getExercises())
                .dateOfTrain(training.getDateOfTrain())
                .nameOfTraining(training.getNameOfTraining())
                .comment(training.getComment())
                .durationOfRun(runs.getDurationOfRun())
                .pause(runs.getPause())
                .repetition(runs.getRepetition())
                .days(training.getDays())
                .build();

        return trainingForUser;

        //budou jenom 1 training mapper ktery bude mapovat jenom zakladni data o treninku.
        //ostatni tridy warmUp atd se udelali jednotlive mappery

    }

}
