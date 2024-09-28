package com.example.demo.dto;


import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;


@Builder
@Getter
@Setter
public class TrainingDto {

    private Long trainingID;

    private LocalDate dateOfTrain;

    private String nameOfTraining;

    private String comment;

    private String userlastname;

    private String userfirstname;
}
