package com.example.youquiz.student;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping(path = "/api/Student")
public class StudentController {

    @Autowired
    private StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping(path = "{studentId}")
    public ResponseEntity<StudentDTO> findById(@PathVariable int studentId) {
        return new ResponseEntity<>(studentService.findById(studentId), HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<StudentDTO>> findAll(){
        return new ResponseEntity<>(studentService.findAll(), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<StudentDTO> save(@RequestBody StudentDTO studentDTO){
        return new ResponseEntity<>(studentService.save(studentDTO), HttpStatus.OK);
    }

    @DeleteMapping(path = "{studentId}")
    public ResponseEntity<StudentDTO> delete(@PathVariable int studentId){
        return new ResponseEntity<>(studentService.deleteById(studentId), HttpStatus.OK);
    }

}
