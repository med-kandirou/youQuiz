package com.example.youquiz.validation;

import com.example.youquiz.assignment.AssignementTDOReq;
import com.example.youquiz.assignment.AssignementTDORes;

import java.util.List;

public interface IValidation {
    List<ValidationDTORes> findAll();
    ValidationDTORes findById(int id);
    ValidationDTOReq save(ValidationDTOReq validationDTOReq);
    AssignementTDORes deleteById(int id);
    ValidationDTOReq update(ValidationDTOReq validationDTOReq);
    List<ValidationDTORes> findValidationByQuestion(int questionId);
}
