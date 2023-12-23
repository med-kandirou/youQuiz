package com.example.youquiz.question;


import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/api/Question")
public class QuestionController {

    @Autowired
    private QuestionService questionService;

    private QuestionController(QuestionService questionService){
        this.questionService=questionService;
    }


    @GetMapping(path = "/all")
    public ResponseEntity<List<QuestionDTORes>> all(){
        return new ResponseEntity<>(questionService.all(), HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<Page<QuestionDTORes>> getAll(Pageable pageable){
        return new ResponseEntity<>(questionService.findAll(pageable), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<QuestionDTOReq> save(@Valid @RequestBody QuestionDTOReq QuestionDTOReq){
        return new ResponseEntity<>(questionService.save(QuestionDTOReq), HttpStatus.OK);
    }

    @PutMapping
    public ResponseEntity<QuestionDTOReq> update(@Valid @RequestBody QuestionDTOReq QuestionDTOReq){
        return new ResponseEntity<>(questionService.save(QuestionDTOReq), HttpStatus.OK);
    }

    @GetMapping(path = {"{questionId}"})
    public ResponseEntity<QuestionDTORes> findById(@PathVariable("questionId") Integer questionId){
        return new ResponseEntity<>(questionService.findById(questionId), HttpStatus.OK);
    }

    @DeleteMapping(path = {"{questionId}"})
    public ResponseEntity<QuestionDTORes> deleteById(@PathVariable("questionId") Integer questionId){
        return new ResponseEntity<>(questionService.deleteById(questionId), HttpStatus.OK);
    }


    @GetMapping(path = {"bySubject/{subjectId}"})
    public ResponseEntity<List<QuestionDTORes>> findBySubjectId(@PathVariable("subjectId") Integer subjectId){;
        return new ResponseEntity<>(questionService.findBySubjectId(subjectId), HttpStatus.OK);
    }

    @GetMapping(path = {"byLevel/{levelId}"})
    public ResponseEntity<List<QuestionDTORes>> findByLevelId(@PathVariable("levelId") Integer levelId){;
        return new ResponseEntity<>(questionService.findByLevelId(levelId), HttpStatus.OK);
    }
}
