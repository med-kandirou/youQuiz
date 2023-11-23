package com.example.youquiz.temporisation;

import com.example.youquiz.Exception.RecordAlreadyExistsException;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/api/Temporisation")
public class TemporisationController {
    @Autowired
    private TemporisationService temporisationService;

    private TemporisationController(TemporisationService temporisationService){
        this.temporisationService=temporisationService;
    }

    @GetMapping(path = "{temporisationId}")
    public ResponseEntity<TemporisationDTORes> findById(@PathVariable int temporisationId) {
        return new ResponseEntity<>(temporisationService.findById(temporisationId), HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<TemporisationDTORes>> findAll(){
        return new ResponseEntity<>(temporisationService.findAll(), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<TemporisationDTOReq> save(@RequestBody @Valid TemporisationDTOReq temporisationDTOReq) throws RecordAlreadyExistsException {
        return new ResponseEntity<>(temporisationService.save(temporisationDTOReq), HttpStatus.OK);
    }

    @PutMapping
    public ResponseEntity<TemporisationDTOReq> update(@RequestBody @Valid TemporisationDTOReq temporisationDTOReq){
        return new ResponseEntity<>(temporisationService.update(temporisationDTOReq), HttpStatus.OK);
    }

    @DeleteMapping(path = "{temporisationId}")
    public ResponseEntity<TemporisationDTOReq> delete(@PathVariable int temporisationId){
        return new ResponseEntity<>(temporisationService.deleteById(temporisationId), HttpStatus.OK);
    }
}
