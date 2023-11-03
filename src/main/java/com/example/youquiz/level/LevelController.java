package com.example.youquiz.level;


import org.springframework.beans.factory.annotation.Autowired;
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
    public List<Level> getAll(){
        return levelService.getAll();
    }

    @PostMapping
    public Level save(@RequestBody Level level){
        return levelService.save(level);
    }

    @GetMapping(path = {"{levelId}"})
    public Level findById(@PathVariable("levelId") Integer id){
        try {
            return levelService.findById(id);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @DeleteMapping(path = {"{questionId}"})
    public void deleteById(@PathVariable("questionId") Integer id){
        try {
            levelService.deleteById(id);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

}
