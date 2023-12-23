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
            Response r1 = new Response("framework");
            Response r2 = new Response("programming language");
            Response r3 = new Response("ORM");
            Response r4 = new Response("hyper text markeup langage");
            Response r5 = new Response("database relational");
            Response r6 = new Response("concept 1");
            Response r7 = new Response("database");
            Response r8 = new Response("language pragramming interpeter");
            Response r9 = new Response("database non relational");
            Response r10 = new Response("tool dev");
            Response r11 = new Response("object oriented programming");
            Response r12 = new Response("concept programming");
            responseRepository.saveAll(List.of(r1, r2, r3, r4,r5,r6, r7, r8, r9, r10, r11, r12));
        };
    }
}
