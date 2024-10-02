package com.example.demo.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.util.List;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Training {

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long trainingID;

    private LocalDate dateOfTrain;

    @OneToMany(mappedBy = "training", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Runs> runs;

    @OneToMany(mappedBy = "training", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<WarmUp> warmUpList;

    @ManyToOne
    @JoinColumn(name = "userId")
    private User user;

    private String nameOfTraining;

    @Column(columnDefinition = "TEXT")
    private String comment;

    public void adjustNumberOf //todo figre this out


}
