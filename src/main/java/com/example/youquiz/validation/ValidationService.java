package com.example.youquiz.validation;

import com.example.youquiz.Exception.RecordAlreadyExistsException;
import com.example.youquiz.Exception.ResourceNotFoundException;
import com.example.youquiz.question.Question;
import com.example.youquiz.question.QuestionRepository;
import com.example.youquiz.response.Response;
import com.example.youquiz.response.ResponseRepository;
import com.example.youquiz.student.StudentRepository;
import com.example.youquiz.trainer.TrainerRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ValidationService implements IValidation{
    @Autowired
    private ValidationRepository validationRepository;
    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private QuestionRepository questionRepository;

    @Autowired
    private ResponseRepository responseRepository;

    private ValidationService(ValidationRepository validationRepository, TrainerRepository trainerRepository, StudentRepository studentRepository){
        this.validationRepository=validationRepository;
    }

    @Override
    public List<ValidationDTORes> findAll() {
        List<Validation> validationDTOResList=validationRepository.findAll();
        return validationDTOResList.stream()
                .map(valid -> modelMapper.map(valid, ValidationDTORes.class))
                .collect(Collectors.toList());
    }

    @Override
    public ValidationDTORes findById(int id) {
        Validation validation = validationRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("id : " + id));
        return modelMapper.map(validation, ValidationDTORes.class);
    }

    @Override
    public ValidationDTOReq save(ValidationDTOReq validationDTOReq) throws RecordAlreadyExistsException {
        boolean exist=validationRepository.existsByQuestionIdAndResponseId(validationDTOReq.getQuestion_id(), validationDTOReq.getResponse_id());
        if (exist) {
             throw new RecordAlreadyExistsException("question_id: " + validationDTOReq.getQuestion_id() + " and response_id: " + validationDTOReq.getResponse_id());
        }
        Validation validation= modelMapper.map(validationDTOReq, Validation.class);
        Question question = questionRepository.findById(validationDTOReq.getQuestion_id())
                .orElseThrow(() -> new ResourceNotFoundException("id : " + validationDTOReq.getQuestion_id()));
        Response response = responseRepository.findById(validationDTOReq.getResponse_id())
                .orElseThrow(() -> new ResourceNotFoundException("id : " + validationDTOReq.getResponse_id()));
        validation.setQuestion(question);
        validation.setResponse(response);
        validationRepository.save(validation);
        return modelMapper.map(validation, ValidationDTOReq.class);
    }


    @Override
    public ValidationDTOReq deleteById(int id) {
        Validation validation = validationRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("id : " + id));
        validationRepository.deleteById(id);
        return modelMapper.map(validation, ValidationDTOReq.class);
    }

    @Override
    public ValidationDTOReq update(ValidationDTOReq validationDTOReq) {
        return null;
    }

    @Override
    public List<ValidationDTORes> findValidationByQuestion(int questionId){
        List<Validation> validationDTOResList=validationRepository.findByQuestionId(questionId);
        return validationDTOResList.stream()
                .map(valid -> modelMapper.map(valid, ValidationDTORes.class))
                .collect(Collectors.toList());
    }





}
