package com.example.demo.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.time.Duration;
import java.time.LocalDate;

@Builder
@Getter
@Setter
public class TrainingForCoachDto {
    private Long trainingID;

    private Long warmUpID;

    private String trot;

    private String exercises;

    private LocalDate dateOfTrain;

    private String nameOfTraining;

    private String comment;

    //Runs
    private Long runsId;

    private Duration durationOfRun;

    private Duration pause;

    private Integer repetition;

    private Integer numberOfRuns;
}
