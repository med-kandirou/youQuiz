package com.example.youquiz.validation;

import com.example.youquiz.question.Question;
import com.example.youquiz.temporisation.Temporisation;
import com.example.youquiz.test.Test;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ValidationRepository extends JpaRepository<Validation,Integer> {
    List<Validation> findByQuestionId(int questionId);
    boolean existsByQuestionIdAndResponseId(int questionId, int responseId);
    List<Validation> findByQuestion(Question question);
    Validation findByQuestionIdAndResponseId(int questionId, int responseId);
}
