package com.example.youquiz.student;



import io.micrometer.core.ipc.http.HttpSender;
import jakarta.validation.Valid;
import org.apache.coyote.Request;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;


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
    public ResponseEntity<Page<StudentDTO>> findAll(Pageable pegeable){
        return new ResponseEntity<>(studentService.findAll(pegeable), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<StudentDTO> save(@Valid @RequestBody StudentDTO studentDTO){
        return new ResponseEntity<>(studentService.save(studentDTO), HttpStatus.OK);
    }

    @DeleteMapping(path = "{studentId}")
    public ResponseEntity<StudentDTO> delete(@PathVariable int studentId){
        return new ResponseEntity<>(studentService.deleteById(studentId), HttpStatus.OK);
    }

    @PostMapping(path = "/login")
    public ResponseEntity<StudentDTO> login(@RequestBody Map<String, String> request){
        return new ResponseEntity<>(studentService.login(request.get("firstName"),request.get("password")), HttpStatus.OK);
    }

}
