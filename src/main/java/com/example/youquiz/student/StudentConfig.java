package com.example.youquiz.student;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.util.List;

@Configuration
public class StudentConfig {
    @Bean
    CommandLineRunner commandLineRunnerStudent(StudentRepository repository){
        return args -> {
            Student student1 = new Student("John", "Doe", LocalDate.of(1995, 5, 15) ,"taza", LocalDate.now(),"pass");
            Student student2 = new Student("med", "kandirou", LocalDate.of(2001, 5, 15), "fes", LocalDate.now(),"pass");
            Student student3 = new Student("Amine", "Hatim", LocalDate.of(1995, 5, 15), "jamma", LocalDate.now(),"pass");
            Student student4 = new Student("Oussama", "haddi", LocalDate.of(2000, 5, 15), "khenifra", LocalDate.now(),"pass");

            repository.saveAll(List.of(student1,student2,student3,student4));
        };
    }
}
