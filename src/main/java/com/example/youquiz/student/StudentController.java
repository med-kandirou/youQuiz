package com.example.youquiz.student;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping(path = "/api/Student")
public class StudentController {

    @Autowired
    private StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping()
    public List<Student> findAll(){
        return studentService.findAll();
    }

    @PostMapping()
    public Student add(@RequestBody Student student){
        return studentService.add(student);
    }

    @GetMapping(path = {"{studentId}"})
    public Student findById(@PathVariable("studentId") Integer code){
        try {
            return studentService.findById(code);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @DeleteMapping(path = {"{studentId}"})
    public String deleteById(@PathVariable("studentId") int id){
        return "deleted "+id;
    }

}
