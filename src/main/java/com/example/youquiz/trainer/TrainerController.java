package com.example.youquiz.trainer;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
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

    @GetMapping(path = "{TrainerId}")
    public ResponseEntity<TrainerDTO> findById(@PathVariable int TrainerId) {
        return new ResponseEntity<>(trainerService.findById(TrainerId), HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<TrainerDTO>> findAll(){
        return new ResponseEntity<>(trainerService.findAll(), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<TrainerDTO> save(@Valid @RequestBody TrainerDTO TrainerDTO){
        return new ResponseEntity<>(trainerService.save(TrainerDTO), HttpStatus.OK);
    }

    @DeleteMapping(path = "{TrainerId}")
    public ResponseEntity<TrainerDTO> delete(@PathVariable int TrainerId){
        return new ResponseEntity<>(trainerService.deleteById(TrainerId), HttpStatus.OK);
    }
}
