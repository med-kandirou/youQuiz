package com.example.youquiz.answer;

import com.example.youquiz.media.MediaRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AnswerConfig {
    @Bean
    CommandLineRunner commandLineRunnerAnswer(AnswerRepository repository){
        return args -> {
        };
    }
}
