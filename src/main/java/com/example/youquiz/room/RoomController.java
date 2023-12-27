package com.example.youquiz.room;


import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/api/Salle")
public class RoomController {

    private final RoomService roomService;

    private RoomController(RoomService roomService){
        this.roomService = roomService;
    }

    @GetMapping
    public ResponseEntity<List<RoomDTOres>> getAll(){
        return new ResponseEntity<>(roomService.findAll(), HttpStatus.OK);
    }

    @GetMapping(path = "{salleId}")
    public ResponseEntity<RoomDTOres> findById(@PathVariable int salleId) {
        return new ResponseEntity<>(roomService.findById(salleId), HttpStatus.OK);
    }

    
    @PostMapping
    public ResponseEntity<RoomDTOres> save(@Valid @RequestBody RoomDTOreq SalleDTO){
        return new ResponseEntity<>(roomService.save(SalleDTO), HttpStatus.OK);
    }

    @DeleteMapping(path = "{salleId}")
    public ResponseEntity<RoomDTOres> delete(@PathVariable int salleId){
        return new ResponseEntity<>(roomService.deleteById(salleId), HttpStatus.OK);
    }
}
