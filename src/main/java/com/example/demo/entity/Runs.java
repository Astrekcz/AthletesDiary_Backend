package com.example.demo.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.*;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Runs {
    @Id
    private Long runsId;

    private String distance;

    private Long duration;

    private Long Break;

    private Integer Repetition = 1;



}