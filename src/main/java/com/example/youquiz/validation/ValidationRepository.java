package com.example.youquiz.validation;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ValidationRepository extends JpaRepository<Validation,Integer> {
    List<ValidationDTORes> findByQuestionId(int questionId);
}
