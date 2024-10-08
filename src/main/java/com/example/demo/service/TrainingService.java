package com.example.demo.service;


import com.example.demo.repository.*;
import com.example.demo.entity.*;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;




import java.time.Duration;
import java.time.LocalDate;

@Service
@RequiredArgsConstructor
@Slf4j
public class TrainingService {
    private final TrainingRepository trainingRepository;
    private final UserRepository userRepository;
    private final UserDetailsService userDetailsService;
    private final WarmUpRepository warmUpRepository;
    private final DistanceRepository distanceRepository;
    private final RunsRepository runsRepository;

    @PreAuthorize("hasRole('USER')")
    @Transactional
    public void saveTraining(String comment, String nameOfTraining,
                              String distance, String exercises,
                              String trot, LocalDate dateOfTrain, Long trainingID,
                              Duration durationOfRun, Duration pause,
                              Integer repetition, Integer numberOfRuns){
        if (durationOfRun.isNegative()){
            throw new IllegalArgumentException("durationOfRun is invalid");
        }else if (pause.isNegative()){
            throw new IllegalArgumentException("pause is invalid");
        }

        Training training1 = trainingRepository.findById(trainingID)
                .orElseThrow(() -> new RuntimeException("training record not found"));

        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String username = authentication.getName(); //this is email address

        //load user details
        UserDetails userDetails = userDetailsService.loadUserByUsername(username);
        User user = userRepository.findByEmail(userDetails.getUsername())
                .orElseThrow(() -> new UsernameNotFoundException(username));

        WarmUp warmUp = WarmUp.builder()
                .trot(trot)
                .exercises(exercises)
                .build();

        Training training = Training.builder()
                .dateOfTrain(dateOfTrain)
                .nameOfTraining(nameOfTraining)
                .comment(comment)
                .build();

        Distance distances = Distance.builder()
                .distance(distance)
                .build();

        Runs runs = Runs.builder()
                .durationOfRun(durationOfRun)
                .pause(pause)
                .repetition(repetition)
                .numberOfRuns(numberOfRuns)
                .build();

        //Setting relation between databases
        warmUp.setTraining(training);
        distances.setRuns(runs);
        runs.setTraining(training);
        training.setUser(user);

        // saving to repositories
        trainingRepository.save(training);
        warmUpRepository.save(warmUp);
        runsRepository.save(runs);
        distanceRepository.save(distances);


    }


}
