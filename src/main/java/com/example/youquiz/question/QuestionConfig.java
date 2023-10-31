package com.example.youquiz.question;

import com.example.youquiz.level.Level;
import com.example.youquiz.subject.Subject;
import com.example.youquiz.subject.SubjectRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;

import java.util.List;

public class QuestionConfig {
    @Bean
    CommandLineRunner commandLineRunner(QuestionRepository questionRepository){
        return Arg->{
            Level level = new Level();
            Subject subject= new Subject();
            level.setId(1);
            subject.setId(1);
            Question q1= new Question(2,1,"what is java ?","image",subject,level);
            Question q2= new Question(3,1,"what is spring boot ?","image",subject,level);
            level.setId(2);
            subject.setId(2);
            Question q3= new Question(4,2,"what is js?","image",subject,level);
            questionRepository.saveAll(List.of(q1,q2,q3));
        };
    }
}
