package com.example.youquiz.response;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/api/Response")
public class ResponseController {
    @Autowired
    private ResponseService responseService;

    private ResponseController(ResponseService ResponseServise){
        this.responseService=ResponseServise;
    }

    @GetMapping(path = "{responseId}")
    public ResponseEntity<ResponseDTO> findById(@PathVariable int responseId) {
        return new ResponseEntity<>(responseService.findById(responseId), HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<ResponseDTO>> findAll(){
        return new ResponseEntity<>(responseService.findAll(), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<ResponseDTO> save(@Valid @RequestBody ResponseDTO ResponseDTO){
        return new ResponseEntity<>(responseService.save(ResponseDTO), HttpStatus.OK);
    }

    @DeleteMapping(path = "{responseId}")
    public ResponseEntity<ResponseDTO> delete(@PathVariable int responseId){
        return new ResponseEntity<>(responseService.deleteById(responseId), HttpStatus.OK);
    }
}
