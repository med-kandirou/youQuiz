package com.example.youquiz.question;

import com.example.youquiz.student.Student;
import com.example.youquiz.student.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class QuestionService {
    @Autowired
    private QuestionRepository questionRepository;

    public QuestionService(QuestionRepository questionRepository) {
        this.questionRepository = questionRepository;
    }

    public List<Question> getAll(){
        return questionRepository.findAll();
    }

    public Question findById(int id) throws Exception {
        Optional<Question> optional=questionRepository.findById(id);
        if(optional.isPresent()){
            return optional.get();
        }
        throw new Exception("Question not found");
    }


    public void deleteById(int id){
        questionRepository.deleteById(id);
    }

}

