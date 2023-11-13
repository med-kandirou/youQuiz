package com.example.youquiz.validation;

import com.example.youquiz.question.Question;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ValidationService {
    @Autowired
    private ValidationRepository validationRepository;
    private ValidationService(ValidationRepository ValidationRepository){
        this.validationRepository=ValidationRepository;
    }

    public List<Validation> findValidationByQuestion(int questionId){
        return validationRepository.findByQuestionId(questionId);
    }
}
