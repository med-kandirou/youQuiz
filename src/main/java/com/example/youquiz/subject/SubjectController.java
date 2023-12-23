package com.example.youquiz.subject;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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

    @GetMapping(path = "{subjectId}")
    public ResponseEntity<SubjectDTOResp> findById(@PathVariable int subjectId) {
        return new ResponseEntity<>(subjectService.findById(subjectId), HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<SubjectDTOResp>> findAll(){
        return new ResponseEntity<>(subjectService.findAll(), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<SubjectDTOReq> save(@Valid @RequestBody SubjectDTOReq subjectDTOReq){
        return new ResponseEntity<>(subjectService.save(subjectDTOReq), HttpStatus.OK);
    }

    @PutMapping
    public ResponseEntity<SubjectDTOReq> update(@Valid @RequestBody SubjectDTOReq subjectDTOReq){
        return new ResponseEntity<>(subjectService.save(subjectDTOReq), HttpStatus.OK);
    }
    @DeleteMapping(path = "{subjectId}")
    public ResponseEntity<SubjectDTOResp> delete(@PathVariable int subjectId){
        return new ResponseEntity<>(subjectService.deleteById(subjectId), HttpStatus.OK);
    }

}
