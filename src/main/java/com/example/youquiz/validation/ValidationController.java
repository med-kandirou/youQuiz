package com.example.youquiz.validation;

import com.example.youquiz.Exception.RecordAlreadyExistsException;
import com.example.youquiz.assignment.AssignementTDORes;
import com.example.youquiz.question.Question;
import com.example.youquiz.test.TestDTO;
import com.example.youquiz.test.TestDTOReq;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.function.EntityResponse;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping(path = "/api/Validation")
public class ValidationController {

    @Autowired
    private ValidationService validationService;


    private ValidationController(ValidationService validationService){
        this.validationService=validationService;
    }

    @GetMapping("/Question/{QuestionId}")
    public ResponseEntity<List<ValidationDTORes>> findValidationByQuestion(@PathVariable int QuestionId){
        return new ResponseEntity<>(validationService.findValidationByQuestion(QuestionId), HttpStatus.OK);
    }

    @GetMapping(path = "{validationId}")
    public ResponseEntity<ValidationDTORes> findById(@PathVariable int validationId) {
        return new ResponseEntity<>(validationService.findById(validationId), HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<ValidationDTORes>> findAll(){
        return new ResponseEntity<>(validationService.findAll(), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<ValidationDTOReq> save(@Valid @RequestBody ValidationDTOReq validationDTOReq) throws RecordAlreadyExistsException {
        return new ResponseEntity<>(validationService.save(validationDTOReq), HttpStatus.OK);
    }

    @DeleteMapping(path = "{validationId}")
    public ResponseEntity<ValidationDTOReq> delete(@PathVariable int validationId){
        return new ResponseEntity<>(validationService.deleteById(validationId), HttpStatus.OK);
    }


    @GetMapping(path = "/byQuestion/{questionId}")
    public ResponseEntity<List<ValidationDTORes>> findByQuestion(@PathVariable int questionId){
        return new ResponseEntity<>(validationService.findByQuestion(questionId), HttpStatus.OK);
    }

    @PostMapping(path = "/verifyResponses")
    public ResponseEntity<Double> validateResponses(@RequestBody Map<String, List<Integer>> request){
        List<Integer> idsValidations = request.get("ids_validations");
        return new ResponseEntity<>(validationService.verifyResponses(idsValidations), HttpStatus.OK);
    }
}
