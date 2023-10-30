package com.example.youquiz.Student;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

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

    /*@PostMapping()
    public Student add(@RequestBody Student student){
        return studentService.add(student);
    }*/

    @PostMapping()
    public int getStudentbyId(@RequestBody Student student){
        return student.getCode();
        /*try {
            return studentService.getStudentbyId(id);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }*/
    }

}
