package com.example.youquiz.test;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/api/Test")
public class TestController {

    @Autowired
    private TestService testService;

    private TestController(TestService testService){
        this.testService=testService;
    }

    @GetMapping(path = "{testId}")
    public ResponseEntity<TestDTO> findById(@PathVariable int testId) {
        return new ResponseEntity<>(testService.findById(testId), HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<TestDTO>> findAll(){
        return new ResponseEntity<>(testService.findAll(), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<TestDTOReq> save(@RequestBody @Valid TestDTOReq testDTOReq){
        return new ResponseEntity<>(testService.save(testDTOReq), HttpStatus.OK);
    }

    @DeleteMapping(path = "{testId}")
    public ResponseEntity<TestDTO> delete(@PathVariable int testId){
        return new ResponseEntity<>(testService.deleteById(testId), HttpStatus.OK);
    }
}
