package com.example.youquiz.answer;

import com.example.youquiz.Exception.ResourceNotFoundException;
import com.example.youquiz.assignment.AssignementTDORes;
import com.example.youquiz.assignment.Assignment;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class AnswerService implements IAnswer{

    @Autowired
    private AnswerRepository answerRepository;
    @Autowired
    private ModelMapper modelMapper;

    public AnswerService(AnswerRepository answerRepository) {
        this.answerRepository=answerRepository;
    }

    @Override
    public List<AnswerDTORes> findAll() {
        List<Answer> answers = answerRepository.findAll();
        return answers.stream()
                .map(ans -> modelMapper.map(ans, AnswerDTORes.class))
                .collect(Collectors.toList());
    }

    @Override
    public AnswerDTORes findById(int id) {
        Answer answer = answerRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("id : " + id));
        return modelMapper.map(answer, AnswerDTORes.class);
    }

    @Override
    public AnswerDTOReq save(AnswerDTOReq answerDTOReq) {
        return null;
    }

    @Override
    public AnswerDTORes deleteById(int id) {
        Answer answer = answerRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("id : " + id));
        answerRepository.deleteById(id);
        return modelMapper.map(answer, AnswerDTORes.class);
    }

    @Override
    public AnswerDTOReq update(AnswerDTOReq answerDTOReq) {
        return null;
    }
}
