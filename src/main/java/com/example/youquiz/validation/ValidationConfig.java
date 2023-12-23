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
            q2.setId(2);
            Question q3 = new Question();
            q3.setId(3);
            Question q4 = new Question();
            q4.setId(4);
            Question q5 = new Question();
            q5.setId(5);

            Response r1 = new Response();
            r1.setId(1);
            Response r2 = new Response();
            r2.setId(2);
            Response r3 = new Response();
            r3.setId(3);
            Response r4 = new Response();
            r4.setId(4);
            Response r5 = new Response();
            r5.setId(5);
            Response r6 = new Response();
            r6.setId(6);
            Response r7 = new Response();
            r7.setId(7);
            Response r8 = new Response();
            r8.setId(8);
            Response r9 = new Response();
            r9.setId(9);

            Response r11 = new Response();
            r11.setId(11);
            Response r12 = new Response();
            r12.setId(12);

            Validation v1 = new Validation(3.0, r2,q1);
            Validation v2 = new Validation(0.0, r4,q1);
            Validation v3 = new Validation(0.0, r5,q1);
            Validation v4 = new Validation(3.0, r2,q1);
            ////
            Validation v5 = new Validation(2.0, r1,q2);
            Validation v6 = new Validation(0.0, r3,q2);
            Validation v7 = new Validation(0.0, r2,q2);
            Validation v8 = new Validation(0.0, r5,q2);
            ////
            Validation v9 = new Validation(2.0, r4,q3);
            Validation v10 = new Validation(0.0, r5,q3);
            Validation v11 = new Validation(0.0, r1,q3);
            Validation v12 = new Validation(0.0, r5,q3);
            ////
            Validation v13 = new Validation(2.0, r2,q4);
            Validation v14 = new Validation(2.0, r8,q4);
            Validation v15 = new Validation(0.0, r4,q4);
            Validation v16 = new Validation(0.0, r1,q4);

            ////
            Validation v17 = new Validation(2.0, r11,q5);
            Validation v18 = new Validation(0.0, r9,q5);
            Validation v19 = new Validation(2.0, r12,q5);
            Validation v20 = new Validation(0.0, r1,q5);

            validationRepository.saveAll(List.of(v1, v2, v3, v4, v5, v6, v7, v8, v9, v10, v11, v12, v13, v14, v15, v16, v17, v18, v19, v20));
        };
    }
}
