package com.example.youquiz.trainer;

import com.example.youquiz.student.Student;
import com.example.youquiz.student.StudentRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.util.List;

@Configuration
public class TrainerConfig {
    @Bean
    CommandLineRunner commandLineRunnerTrainer(TrainerRepository repository){
        return args -> {
            Trainer trainer1 = new Trainer("formateur", "safi", LocalDate.of(1995, 5, 15), "taza", "java");
            Trainer trainer2 = new Trainer("formateur", "youssoufia", LocalDate.of(1995, 5, 15), "fes", "javaScript");
            repository.saveAll(List.of(trainer1,trainer2));
        };
    }

}
