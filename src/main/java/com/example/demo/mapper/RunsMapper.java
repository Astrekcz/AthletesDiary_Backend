package com.example.demo.mapper;

import com.example.demo.dto.RunsDto;
import com.example.demo.entity.Runs;
import org.springframework.stereotype.Component;

@Component
public class RunsMapper {

    public RunsDto RunsEntityToRunsDto(Runs runs) {
        RunsDto runsDto = RunsDto.builder()
                .runsId(runs.getRunsId())
                .durationOfRun(runs.getDurationOfRun())
                .pause(runs.getPause())
                .numberOfRuns(runs.getNumberOfRuns())
                .repetition(runs.getRepetition())
                .build();
        return runsDto;
    }
    public RunsDto RunsForUserDto(Runs runs) {
        RunsDto runsDto = RunsDto.builder()
                .runsId(runs.getRunsId())
                .durationOfRun(runs.getDurationOfRun())
                .pause(runs.getPause())
                .numberOfRuns(runs.getNumberOfRuns())
                .repetition(runs.getRepetition())
                .build();
        return runsDto;
    }
    public RunsDto RunsForCoachDto(Runs runs) {
        RunsDto runsDto = RunsDto.builder()
                .runsId(runs.getRunsId())
                .durationOfRun(runs.getDurationOfRun())
                .pause(runs.getPause())
                .numberOfRuns(runs.getNumberOfRuns())
                .repetition(runs.getRepetition())
                .build();
        return runsDto;
    }

}
