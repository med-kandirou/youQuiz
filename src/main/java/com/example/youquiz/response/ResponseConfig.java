package com.example.youquiz.response;


import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;


@Configuration
public class ResponseConfig {
    @Bean
    CommandLineRunner commandLineRunnerResponse(ResponseRepository responseRepository) {
        return args -> {
            Response r1= new Response("freamwork");
            Response r2= new Response("langage de programmation");
            Response r3= new Response("ORM");
            responseRepository.saveAll(List.of(r1,r2,r3));
        };
    }
}
