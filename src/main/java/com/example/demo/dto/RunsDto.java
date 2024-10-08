package com.example.demo.dto;


import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.time.Duration;

@Builder
@Getter
@Setter
public class RunsDto {

    private Long runsId;

    private Duration durationOfRun;

    private Duration pause;

    private Integer numberOfRuns;

    private Integer repetition;

}
