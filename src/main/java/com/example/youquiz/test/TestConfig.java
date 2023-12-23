package com.example.youquiz.test;

import com.example.youquiz.trainer.Trainer;
import com.example.youquiz.trainer.TrainerRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.util.List;


@Configuration
public class TestConfig {
    @Bean
    CommandLineRunner commandLineRunnerTest(TestRepository testRepository, TrainerRepository trainerRepository) {
        return args -> {
            Trainer trainer1 = new Trainer("formateur", "youssef", LocalDate.of(1995, 5, 15), "safi", "java");
            Trainer trainer2 = new Trainer("formateur", "tais", LocalDate.of(1980, 5, 15), "taza", ".NET");
            trainerRepository.saveAll(List.of(trainer1,trainer2));
            Test test1 = new Test(12, true, true, 3, "This is a test", "Read the instructions carefully",trainer1);
            Test test2 = new Test(15, true, false, 3, "This is a test 2", "Read the instructions carefully",trainer2);
            testRepository.saveAll(List.of(test1,test2));
        };
    }
}
