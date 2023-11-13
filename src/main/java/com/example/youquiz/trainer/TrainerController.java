package com.example.youquiz.trainer;


import com.example.youquiz.student.StudentDTO;
import com.example.youquiz.student.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/api/Trainer")
public class TrainerController {
    @Autowired
    private TrainerService trainerService;

    public TrainerController(TrainerService trainerService) {
        this.trainerService = trainerService;
    }

    @GetMapping(path = "{studentId}")
    public ResponseEntity<StudentDTO> findById(@PathVariable int studentId) {
        return new ResponseEntity<>(trainerService.findById(studentId), HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<StudentDTO>> findAll(){
        return new ResponseEntity<>(trainerService.findAll(), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<StudentDTO> save(@RequestBody StudentDTO studentDTO){
        return new ResponseEntity<>(trainerService.save(studentDTO), HttpStatus.OK);
    }

    @DeleteMapping(path = "{studentId}")
    public ResponseEntity<StudentDTO> delete(@PathVariable int studentId){
        return new ResponseEntity<>(trainerService.deleteById(studentId), HttpStatus.OK);
    }
}
