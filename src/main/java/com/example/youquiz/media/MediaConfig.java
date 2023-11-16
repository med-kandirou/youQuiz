package com.example.youquiz.media;


import com.example.youquiz.level.Level;
import com.example.youquiz.level.LevelRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class MediaConfig {
    @Bean
    CommandLineRunner commandLineRunnerMedia(MediaRepository repository){
        return args -> {

        };
    }
}
