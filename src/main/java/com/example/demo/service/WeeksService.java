package com.example.demo.service;

import com.example.demo.Repository.WeekRepository;
import com.example.demo.entity.Week;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class WeeksService {
    private final WeekRepository weekRepository;

    /*public Week saveWeek(){

    }*/
}
