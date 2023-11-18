package com.example.youquiz.answer;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/api/Answer")
public class AnswerController {
    @Autowired
    private AnswerService answerService;

    private AnswerController(AnswerService answerService){
        this.answerService=answerService;
    }

    @GetMapping
    public ResponseEntity<List<AnswerDTORes>> getAll(){
        return new ResponseEntity<>(answerService.findAll(), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<AnswerDTOReq> save(@Valid @RequestBody AnswerDTOReq answerDTOReq){
        return new ResponseEntity<>(answerService.save(answerDTOReq), HttpStatus.OK);
    }

    @GetMapping(path = {"{answertId}"})
    public ResponseEntity<AnswerDTORes> findById(@PathVariable("answertId") Integer answertId){
        return new ResponseEntity<>(answerService.findById(answertId), HttpStatus.OK);
    }

    @DeleteMapping(path = {"{answertId}"})
    public ResponseEntity<AnswerDTORes> deleteById(@PathVariable("answertId") Integer answertId){
        return new ResponseEntity<>(answerService.deleteById(answertId), HttpStatus.OK);
    }
}
