package com.example.youquiz.validation;

import com.example.youquiz.assignment.AssignementTDORes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ValidationService implements IValidation{
    @Autowired
    private ValidationRepository validationRepository;
    private ValidationService(ValidationRepository ValidationRepository){
        this.validationRepository=ValidationRepository;
    }

    @Override
    public List<ValidationDTORes> findAll() {
        return null;
    }

    @Override
    public ValidationDTORes findById(int id) {
        return null;
    }

    @Override
    public ValidationDTOReq save(ValidationDTOReq validationDTOReq) {
        return null;
    }

    @Override
    public AssignementTDORes deleteById(int id) {
        return null;
    }

    @Override
    public ValidationDTOReq update(ValidationDTOReq validationDTOReq) {
        return null;
    }

    @Override
    public List<ValidationDTORes> findValidationByQuestion(int questionId){
        return validationRepository.findByQuestionId(questionId);
    }





}
