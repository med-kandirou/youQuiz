package com.example.youquiz.test;

import com.example.youquiz.trainer.Trainer;
import com.example.youquiz.trainer.TrainerRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;


@Configuration
public class TestConfig {
    @Bean
    CommandLineRunner commandLineRunnerTest(TestRepository testRepository, TrainerRepository trainerRepository) {
        return args -> {
            Trainer trainer1 = new Trainer("formateur", "safi", LocalDate.of(1995, 5, 15), "taza", "java");
            trainerRepository.save(trainer1);
            Test test = new Test(80, true, true, 3, "This is a test", "Read the instructions carefully",trainer1);
            testRepository.save(test);
        };
    }
}
