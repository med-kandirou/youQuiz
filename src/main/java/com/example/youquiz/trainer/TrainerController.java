package com.example.youquiz.trainer;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
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

    @GetMapping(path = "{TrainerId}")
    public ResponseEntity<TrainerDTO> findById(@PathVariable int TrainerId) {
        return new ResponseEntity<>(trainerService.findById(TrainerId), HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<Page<TrainerDTO>> findAll(Pageable pageable){
        return new ResponseEntity<>(trainerService.findAll(pageable), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<TrainerDTO> save(@Valid @RequestBody TrainerDTO TrainerDTO){
        return new ResponseEntity<>(trainerService.save(TrainerDTO), HttpStatus.OK);
    }

    @DeleteMapping(path = "{TrainerId}")
    public ResponseEntity<TrainerDTO> delete(@PathVariable int TrainerId){
        return new ResponseEntity<>(trainerService.deleteById(TrainerId), HttpStatus.OK);
    }

    @PutMapping()
    public ResponseEntity<TrainerDTO> update(@Valid @RequestBody TrainerDTO trainerDTO){
        return new ResponseEntity<>(trainerService.update(trainerDTO), HttpStatus.OK);
    }
}
