package com.example.youquiz.level;


import com.example.youquiz.question.Question;
import com.example.youquiz.trainer.TrainerDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/api/Level")
public class LevelController {

    @Autowired
    private LevelService levelService;

    private LevelController(LevelService levelService){
        this.levelService=levelService;
    }

    @GetMapping
    public ResponseEntity<List<LevelDTO>> getAll(){
        return new ResponseEntity<>(levelService.findAll(), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<LevelDTO> save(@RequestBody LevelDTO LevelDTO){
        return new ResponseEntity<>(levelService.save(LevelDTO), HttpStatus.OK);
    }

    @GetMapping(path = {"{levelId}"})
    public ResponseEntity<LevelDTO> findById(@PathVariable("levelId") Integer levelId){
        return new ResponseEntity<>(levelService.findById(levelId), HttpStatus.OK);
    }

    @DeleteMapping(path = {"{levelId}"})
    public ResponseEntity<LevelDTO> deleteById(@PathVariable("levelId") Integer levelId){
        return new ResponseEntity<>(levelService.deleteById(levelId), HttpStatus.OK);
    }


}
