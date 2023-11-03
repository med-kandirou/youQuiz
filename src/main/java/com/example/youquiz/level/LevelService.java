package com.example.youquiz.level;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LevelService {
    
    @Autowired
    private LevelRepository levelRepository;
    private LevelService(LevelRepository levelRepository){
        this.levelRepository=levelRepository;
    }

    public List<Level> getAll(){
        return levelRepository.findAll();
    }

    public Level findById(int id) throws Exception {
        Optional<Level> optional=levelRepository.findById(id);
        if(optional.isPresent()){
            return optional.get();
        }
        throw new Exception("Question not found");
    }


    public void deleteById(int id){
        levelRepository.deleteById(id);
    }

    public Level save(Level level){
        return levelRepository.save(level);
    }
}
