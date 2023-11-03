package com.example.youquiz.subject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SubjectService {

    @Autowired
    private SubjectRepository subjectRepository;
    private SubjectService(SubjectRepository subjectRepository){
        this.subjectRepository=subjectRepository;
    }


    public List<Subject> getAll(){
        return subjectRepository.findAll();
    }

    public Subject findById(int id) throws Exception {
        Optional<Subject> optional=subjectRepository.findById(id);
        if(optional.isPresent()){
            return optional.get();
        }
        throw new Exception("Question not found");
    }


    public void deleteById(int id){
        subjectRepository.deleteById(id);
    }

    public Subject save(Subject subject){
        return subjectRepository.save(subject);
    }
}
