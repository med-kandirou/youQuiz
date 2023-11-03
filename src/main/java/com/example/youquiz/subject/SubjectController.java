package com.example.youquiz.subject;

import com.example.youquiz.question.Question;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping(path = "/api/Subject")
public class SubjectController {
    @Autowired
    private SubjectService subjectService;

    private SubjectController(SubjectService subjectService){
        this.subjectService=subjectService;
    }

    @GetMapping
    public List<Subject> getAll(){
        return subjectService.getAll();
    }

    @PostMapping
    public Subject save(@RequestBody Subject subject){
        return subjectService.save(subject);
    }

    @GetMapping(path = {"{subjectId}"})
    public Subject findById(@PathVariable("subjectId") Integer id){
        try {
            return subjectService.findById(id);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @DeleteMapping(path = {"{subjectId}"})
    public void deleteById(@PathVariable("subjectId") Integer id){
        try {
            subjectService.deleteById(id);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }


}
