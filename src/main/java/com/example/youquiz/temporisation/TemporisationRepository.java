package com.example.youquiz.temporisation;

import org.springframework.data.jpa.repository.JpaRepository;

public interface TemporisationRepository extends JpaRepository<Temporisation,Integer> {
    boolean existsByQuestionIdAndTestId(int questionId, int testId);
}
