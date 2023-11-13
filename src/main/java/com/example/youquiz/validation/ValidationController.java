package com.example.youquiz.validation;

import com.example.youquiz.question.Question;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/api/Validation")
public class ValidationController {

    @Autowired
    private ValidationService validationService;


    private ValidationController(ValidationService validationService){
        this.validationService=validationService;
    }

    @GetMapping("/Question/{QuestionId}")
    public List<Validation> findValidationByQuestion(@PathVariable int QuestionId){
        return validationService.findValidationByQuestion(QuestionId);
    }

}
