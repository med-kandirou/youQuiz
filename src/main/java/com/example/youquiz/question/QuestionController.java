package com.example.youquiz.question;


import org.springframework.beans.factory.annotation.Autowired;
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

    @GetMapping
    public List<Question> getAll(){
        return questionService.getAll();
    }

    @PostMapping
    public Question save(@RequestBody Question Question){
        return questionService.save(Question);
    }

    @GetMapping(path = {"{questionId}"})
    public Question findById(@PathVariable("questionId") Integer id){
        try {
            return questionService.findById(id);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @DeleteMapping(path = {"{questionId}"})
    public void deleteById(@PathVariable("questionId") Integer id){
        try {
            questionService.deleteById(id);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }


    @GetMapping(path = {"bySubject/{subjectId}"})
    public List<Question> findBySubjectId(@PathVariable("subjectId") Integer id){;
        try {
            return questionService.findBySubjectId(id);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @GetMapping(path = {"byLevel/{levelId}"})
    public List<Question> findByLevelId(@PathVariable("levelId") Integer id){;
        try {
            return questionService.findByLevelId(id);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

}
