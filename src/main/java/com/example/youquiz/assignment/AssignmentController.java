package com.example.youquiz.assignment;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/api/Assignment")
public class AssignmentController {
    @Autowired
    private AssignmentService assignmentService;

    private AssignmentController(AssignmentService assignmentService){
        this.assignmentService=assignmentService;
    }

    @GetMapping
    public ResponseEntity<List<AssignementTDORes>> getAll(){
        return new ResponseEntity<>(assignmentService.findAll(), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<AssignementTDOReq> save(@Valid @RequestBody AssignementTDOReq assignementTDOReq){
        return new ResponseEntity<>(assignmentService.save(assignementTDOReq), HttpStatus.OK);
    }

    @GetMapping(path = {"{assignmentId}"})
    public ResponseEntity<AssignementTDORes> findById(@PathVariable("assignmentId") Integer assignmentId){
        return new ResponseEntity<>(assignmentService.findById(assignmentId), HttpStatus.OK);
    }

    @DeleteMapping(path = {"{assignmentId}"})
    public ResponseEntity<AssignementTDORes> deleteById(@PathVariable("assignmentId") Integer assignmentId){
        return new ResponseEntity<>(assignmentService.deleteById(assignmentId), HttpStatus.OK);
    }
}
