package com.example.youquiz.subject;


import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class SubjectConfig {
    @Bean
    CommandLineRunner commandLineRunnerSubject(SubjectRepository subjectRepository){
        return Arg->{
            Subject s1= new Subject("Html");
            Subject s2= new Subject("Css");
            subjectRepository.saveAll(List.of(s1,s2));
        };
    }
}

