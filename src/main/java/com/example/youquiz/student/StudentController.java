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
    public List<Student> getStudents(){
        return studentService.getStudents();
    }

    @PostMapping()
    public Student add(@RequestBody Student student){
        return studentService.add(student);
    }

    @GetMapping(path = {"{studentId}"})
    public Student getStudentbyId(@PathVariable("studentId") Integer id){
        try {
            return studentService.getStudentbyId(id);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @DeleteMapping(path = {"{studentId}"})
    public String deleteStudentbyId(@PathVariable("studentId") int id){
        return "deleted "+id;
    }

}
