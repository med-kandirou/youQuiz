package com.example.youquiz.question;

import com.example.youquiz.level.Level;
import com.example.youquiz.subject.Subject;
import com.example.youquiz.subject.SubjectRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class QuestionConfig {
    @Bean
     CommandLineRunner commandLineRunnerQuestion(QuestionRepository questionRepository, SubjectRepository subjectRepository) {
        return args -> {
            // Existing code...
            Subject s1 = new Subject("java");
            Subject s2 = new Subject("js");
            Subject s3 = new Subject("python");
            Subject s4 = new Subject("spring");
            Subject s5 = new Subject("html");
            Subject s6 = new Subject("css");

            subjectRepository.saveAll(List.of(s1, s2, s3, s4, s5, s6));

            Level level1 = new Level();
            level1.setId(1);

            Question q1 = new Question(4, 1, "what is java?", QuestionType.TrueFalse, s1, level1);
            Question q2 = new Question(4, 1, "what is spring boot?", QuestionType.TrueFalse, s4, level1);
            Question q3 = new Question(4, 1, "what is HTML?", QuestionType.TrueFalse, s5, level1);

            level1.setId(2);

            Question q4 = new Question(4, 2, "what is js?", QuestionType.MulipleAnswer, s2, level1);
            Question q5 = new Question(4, 2, "what is OOP?", QuestionType.TrueFalse, s2, level1);
            Question q6 = new Question(4, 2, "what is Node.js?", QuestionType.TrueFalse, s2, level1);
            Question q7 = new Question(4, 2, "what is Express?", QuestionType.TrueFalse, s2, level1);

            Level level2 = new Level();
            level2.setId(3);

            Question q8 = new Question(5, 3, "what is python?", QuestionType.TrueFalse, s3, level2);
            Question q9 = new Question(6, 3, "what is Django?", QuestionType.TrueFalse, s3, level2);

            Level level3 = new Level();
            level3.setId(4);

            Question q10 = new Question(7, 4, "what is CSS?", QuestionType.TrueFalse, s6, level3);
            Question q11 = new Question(8, 4, "what is Flexbox?", QuestionType.TrueFalse, s6, level3);

            Level level4 = new Level();
            level4.setId(5);

            Question q12 = new Question(9, 5, "what is REST?", QuestionType.TrueFalse, s4, level4);
            Question q13 = new Question(10, 5, "what is Spring MVC?", QuestionType.TrueFalse, s4, level4);

            questionRepository.saveAll(List.of(q1, q2, q3, q4, q5, q6, q7, q8, q9, q10, q11, q12, q13));
        };
    }
}
