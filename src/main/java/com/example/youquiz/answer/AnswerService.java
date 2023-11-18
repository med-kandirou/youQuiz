package com.example.youquiz.answer;

import com.example.youquiz.Exception.ResourceNotFoundException;
import com.example.youquiz.assignment.Assignment;
import com.example.youquiz.assignment.AssignmentRepository;
import com.example.youquiz.validation.Validation;
import com.example.youquiz.validation.ValidationRepository;
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
    private AssignmentRepository assignmentRepository;
    @Autowired
    private ValidationRepository validationRepository;
    @Autowired
    private ModelMapper modelMapper;

    public AnswerService(AnswerRepository answerRepository,AssignmentRepository assignmentRepository,ValidationRepository validationRepository) {
        this.answerRepository=answerRepository;
        this.assignmentRepository=assignmentRepository;
        this.validationRepository=validationRepository;
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
        Answer answer= modelMapper.map(answerDTOReq, Answer.class);
        Assignment assignment = assignmentRepository.findById(answerDTOReq.getAssignment_id())
                .orElseThrow(() -> new ResourceNotFoundException("id : " + answerDTOReq.getAssignment_id()));
        Validation validation = validationRepository.findById(answerDTOReq.getValidation_id())
                .orElseThrow(() -> new ResourceNotFoundException("id : " + answerDTOReq.getValidation_id()));
        answer.setAssignment(assignment);
        answer.setValidation(validation);
        answerRepository.save(answer);
        return modelMapper.map(answer, AnswerDTOReq.class);
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
