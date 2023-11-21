package com.example.youquiz.question;

import com.example.youquiz.Exception.ResourceNotFoundException;
import com.example.youquiz.level.Level;
import com.example.youquiz.level.LevelRepository;
import com.example.youquiz.response.Response;
import com.example.youquiz.subject.Subject;
import com.example.youquiz.subject.SubjectDTOReq;
import com.example.youquiz.subject.SubjectRepository;
import com.example.youquiz.test.Test;
import com.example.youquiz.test.TestDTOReq;
import com.example.youquiz.trainer.Trainer;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

import java.util.stream.Collectors;

@Service
public class QuestionService implements IQuestion{
    @Autowired
    private QuestionRepository questionRepository;
    @Autowired
    private LevelRepository levelRepository;
    @Autowired
    private SubjectRepository subjectRepository;

    @Autowired
    private ModelMapper modelMapper;

    public QuestionService(QuestionRepository questionRepository, LevelRepository levelRepository, SubjectRepository subjectRepository) {
        this.questionRepository = questionRepository;
        this.levelRepository = levelRepository;
        this.subjectRepository = subjectRepository;
    }

    @Override
    public Page<QuestionDTORes> findAll(Pageable pageable) {
        Page<Question> questionPage = questionRepository.findAll(pageable);
        return questionPage.map(question -> modelMapper.map(question, QuestionDTORes.class));
    }

    @Override
    public QuestionDTORes findById(int id) {
        Question question = questionRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("id : " + id));
        return modelMapper.map(question, QuestionDTORes.class);
    }

    @Override
    public QuestionDTOReq save(QuestionDTOReq questionDTOReq) {
        Question question= modelMapper.map(questionDTOReq, Question.class);
        Subject sub = subjectRepository.findById(questionDTOReq.getSubject_id())
                .orElseThrow(() -> new ResourceNotFoundException("id : " + questionDTOReq.getSubject_id()));
        Level lvl = levelRepository.findById(questionDTOReq.getLevel_id())
                .orElseThrow(() -> new ResourceNotFoundException("id : " + questionDTOReq.getLevel_id()));
        question.setSubject(sub);
        question.setLevel(lvl);
        questionRepository.save(question);
        return modelMapper.map(question, QuestionDTOReq.class);
    }

    @Override
    public QuestionDTORes deleteById(int id){
        Question question = questionRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("id : " + id));
        questionRepository.deleteById(id);
        return modelMapper.map(question, QuestionDTORes.class);
    }

    @Override
    public QuestionDTOReq update(QuestionDTOReq questionDTOReq) {
        return null;
    }


    public List<QuestionDTORes> findBySubjectId(int subjectId){
        List<Question> questions = questionRepository.findBySubjectId(subjectId);
        return questions.stream()
                .map(question -> modelMapper.map(question, QuestionDTORes.class))
                .collect(Collectors.toList());
    }

    public List<QuestionDTORes> findByLevelId(int levelId){
        List<Question> questions = questionRepository.findByLevelId(levelId);
        return questions.stream()
                .map(question -> modelMapper.map(question, QuestionDTORes.class))
                .collect(Collectors.toList());
    }

}


