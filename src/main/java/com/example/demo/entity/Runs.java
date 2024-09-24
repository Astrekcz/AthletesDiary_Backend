package com.example.demo.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Runs {
    @Id
    private Long runsId;

    @OneToMany(mappedBy = "runs", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Distance> distances;

    private Long duration;

    private Long pause;

    private Integer numberOfRuns;

    @ManyToOne
    @JoinColumn(name = "training_id")
    private Training training;

    private Integer repetition = 1;  // of runs (200m 200m 200m) * 3
}
