package com.example.youquiz.level;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import java.util.List;

@Configuration
public class LevelConfig {
    @Bean
    CommandLineRunner commandLineRunnerLevel(LevelRepository repository){
        return args -> {
            Level level1 = new Level("description level 1",1,3);
            Level level2 = new Level("description level 2",3,6);
            Level level3 = new Level("description level 3",4,6);
            Level level4 = new Level("description level 4",6,8);
            Level level5 = new Level("description level 5",9,11);
            Level level6 = new Level("description level 6",11,13);
            repository.saveAll(List.of(level1,level2,level3,level4,level5,level6));
        };
    }
}
