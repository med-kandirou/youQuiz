package com.example.youquiz.temporisation;

import com.example.youquiz.test.Test;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TemporisationRepository extends JpaRepository<Temporisation,Integer> {
    boolean existsByQuestionIdAndTestId(int questionId, int testId);
    List<Temporisation> findByTest(Test test);
}
