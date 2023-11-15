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
            Subject s1= new Subject("java");
            Subject s2= new Subject("js");
            subjectRepository.saveAll(List.of(s1,s2));
            Level level = new Level();
            level.setId(1);
            Question q1 = new Question(2, 1, "what is java ?", QuestionType.TrueFalse,s1,level);
            Question q2 = new Question(3, 1, "what is spring boot ?", QuestionType.TrueFalse,s1,level);
            level.setId(2);
            Question q3 = new Question(4, 2, "what is js?", QuestionType.TrueFalse, s2, level);
            questionRepository.saveAll(List.of(q1, q2, q3));
        };
    }
}
