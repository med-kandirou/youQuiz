package com.example.youquiz.media;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
public class MediaConfig {
    @Bean
    CommandLineRunner commandLineRunnerMedia(MediaRepository repository){
        return args -> {

        };
    }
}
