package com.example.youquiz.student;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.util.List;

@Configuration
public class StudentConfig {
    @Bean
    CommandLineRunner commandLineRunner(StudentRepository repository){
        return args -> {
            Student student1 = new Student("John", "Doe", LocalDate.of(1995, 5, 15), "taza", LocalDate.now());
            Student student2 = new Student("med", "kandirou", LocalDate.of(1995, 5, 15), "fes", LocalDate.now());
            repository.saveAll(List.of(student1,student2));
        };
    }
}
