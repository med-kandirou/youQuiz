package com.example.youquiz.media;

import com.example.youquiz.level.LevelDTO;
import com.example.youquiz.level.LevelService;
import com.example.youquiz.trainer.TrainerDTO;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/api/Media")
public class MediaController {
    @Autowired
    private MediaService mediaService;

    private MediaController(MediaService mediaService){
        this.mediaService=mediaService;
    }

    @GetMapping
    public ResponseEntity<List<MediaDTORes>> getAll(){
        return new ResponseEntity<>(mediaService.findAll(), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<MediaDTOReq> save(@Valid @RequestBody MediaDTOReq mediaDTOReq){
        return new ResponseEntity<>(mediaService.save(mediaDTOReq), HttpStatus.OK);
    }

    @GetMapping(path = {"{mediaId}"})
    public ResponseEntity<MediaDTORes> findById(@PathVariable("mediaId") Integer mediaId){
        return new ResponseEntity<>(mediaService.findById(mediaId), HttpStatus.OK);
    }

    @DeleteMapping(path = {"{mediaId}"})
    public ResponseEntity<MediaDTORes> deleteById(@PathVariable("mediaId") Integer mediaId){
        return new ResponseEntity<>(mediaService.deleteById(mediaId), HttpStatus.OK);
    }

    @PutMapping()
    public ResponseEntity<MediaDTOReq> update(@Valid @RequestBody MediaDTOReq mediaDTOReq){
        return new ResponseEntity<>(mediaService.update(mediaDTOReq), HttpStatus.OK);
    }

}
