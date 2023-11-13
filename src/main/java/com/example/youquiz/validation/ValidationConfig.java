package com.example.youquiz.validation;

import com.example.youquiz.question.Question;
import com.example.youquiz.response.Response;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class ValidationConfig {
    @Bean
    CommandLineRunner commandLineRunnerValidation(ValidationRepository validationRepository) {
        return args -> {
            Question q1 = new Question();
            q1.setId(1);
            Question q2 = new Question();
            q2.setId(2);  // Fixed the typo here
            Response r1 = new Response();
            r1.setId(1);
            Response r2 = new Response();
            r2.setId(2);

            Validation v1 = new Validation(3.0, q1, r1);
            Validation v2 = new Validation(0.0, q1, r2);
            Validation v3 = new Validation(4.0, q2, r2);
            Validation v4 = new Validation(4.0, q1, r2);

            validationRepository.saveAll(List.of(v1, v2, v3, v4));
        };
    }
}
