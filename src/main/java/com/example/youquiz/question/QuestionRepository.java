package com.example.youquiz.question;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface QuestionRepository extends JpaRepository<Question,Integer> {
    List<Question> findBySubjectId(int subjectId);
    List<Question> findByLevelId(int levelId);
}
