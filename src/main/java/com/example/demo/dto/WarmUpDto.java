package com.example.demo.dto;


import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Builder
@Getter
@Setter
public class WarmUpDto {

    private Long warmUpID;

    private String trot;

    private String exercises;

}
