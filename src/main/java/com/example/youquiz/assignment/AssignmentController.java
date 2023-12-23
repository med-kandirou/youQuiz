package com.example.youquiz.assignment;

import com.example.youquiz.Exception.RecordAlreadyExistsException;
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
    public ResponseEntity<AssignementTDOReq> save(@Valid @RequestBody AssignementTDOReq assignementTDOReq) throws RecordAlreadyExistsException {
        return new ResponseEntity<>(assignmentService.save(assignementTDOReq), HttpStatus.OK);
    }

    @PutMapping
    public ResponseEntity<AssignementTDOReq> update(@Valid @RequestBody AssignementTDOReq assignementTDOReq){
        return new ResponseEntity<>(assignmentService.update(assignementTDOReq), HttpStatus.OK);
    }

    @GetMapping(path = {"{assignmentId}"})
    public ResponseEntity<AssignementTDORes> findById(@PathVariable("assignmentId") Integer assignmentId){
        return new ResponseEntity<>(assignmentService.findById(assignmentId), HttpStatus.OK);
    }

    @DeleteMapping(path = {"{assignmentId}"})
    public ResponseEntity<AssignementTDORes> deleteById(@PathVariable("assignmentId") Integer assignmentId){
        return new ResponseEntity<>(assignmentService.deleteById(assignmentId), HttpStatus.OK);
    }

    @GetMapping(path = {"byStudent/{studentId}/{isPassed}"})
    public ResponseEntity<List<AssignementTDORes>> byStudentIdandStatus(@PathVariable("studentId") Integer studentId,@PathVariable("isPassed") boolean isPassed){
        return new ResponseEntity<>(assignmentService.findByStudent(studentId,isPassed), HttpStatus.OK);
    }

    @GetMapping(path = {"{assignmentId}/passed"})
    public ResponseEntity<AssignementTDORes> changeToPassed(@PathVariable("assignmentId") Integer assignmentId){
        return new ResponseEntity<>(assignmentService.changeToPassed(assignmentId), HttpStatus.OK);
    }
}
