package com.example.demo.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class WarmUp {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long warmUpID;

    private String trot;

    @Column(columnDefinition = "TEXT")
    private String exercises;

    @ManyToOne
    @JoinColumn(name = "training_id")
    private Training training;

}
