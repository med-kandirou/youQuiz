package com.example.youquiz.subject;


import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class SubjectConfig {
    @Bean
    CommandLineRunner commandLineRunner(SubjectRepository subjectRepository){
        return Arg->{
            Subject s1= new Subject("java");
            Subject s2= new Subject("js");
            subjectRepository.saveAll(List.of(s1,s2));
        };
    }
}
