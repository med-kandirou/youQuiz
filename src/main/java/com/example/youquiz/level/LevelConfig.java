package com.example.youquiz.level;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import java.util.List;

@Configuration
public class LevelConfig {
    @Bean
    CommandLineRunner commandLineRunner(LevelRepository repository){
        return args -> {
            Level level1 = new Level("description level 1",1,3);
            Level level2 = new Level("description level 2",3,6);
            repository.saveAll(List.of(level1,level2));
        };
    }
}
