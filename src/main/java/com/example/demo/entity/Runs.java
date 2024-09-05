package com.example.demo.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Runs {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long runsId;

    @Column(columnDefinition = "TEXT")
    private String distance;

    private Long duration;

    private Long pause;

    @Enumerated(EnumType.STRING)
    private RunsType runsType;

    @ManyToOne
    @JoinColumn(name = "training_id")
    private Training training;

    private Integer repetition = 1;  //of runs (200m 200m 200m) * 3



}
