package com.example.youquiz.question;

import com.example.youquiz.student.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(path = "/api/Question")
public class QuestionController {

    @Autowired
    private QuestionService questionService;

    private QuestionController(QuestionService questionService){
        this.questionService=questionService;
    }

    @GetMapping()
    public List<Question> getAll(){
        return questionService.getAll();
    }

    @GetMapping(path = {"{questionId}"})
    public Question findById(@PathVariable("questionId") Integer id){;
        try {
            return questionService.findById(id);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
