package com.example.youquiz.test;

import com.example.youquiz.Exception.ResourceNotFoundException;
import com.example.youquiz.trainer.Trainer;
import com.example.youquiz.trainer.TrainerRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class TestService implements ITest{

    @Autowired
    private TestRepository testRepository;

    @Autowired
    private TrainerRepository trainerRepository;

    @Autowired
    private ModelMapper modelMapper;

    private TestService(TestRepository testRepository,TrainerRepository trainerRepository){
        this.testRepository=testRepository;
        this.trainerRepository=trainerRepository;

    }

    
    @Override
    public List<TestDTO> findAll() {
        List<Test> responses = testRepository.findAll();
        return responses.stream()
                .map(test -> modelMapper.map(test, TestDTO.class))
                .collect(Collectors.toList());
    }

    @Override
    public TestDTO findById(int id) {
        Test test = testRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("id : " + id));
        return modelMapper.map(test, TestDTO.class);
    }

    @Override
    public TestDTORes save(TestDTORes testDTORes) {
        Test test = modelMapper.map(testDTORes, Test.class);
        Trainer trainer = trainerRepository.findById(testDTORes.getTrainer_matricule()).orElseThrow(() -> new ResourceNotFoundException("id : " + testDTORes.getTrainer_matricule()));
        test.setTrainer(trainer);
        testRepository.save(test);
        return modelMapper.map(test, TestDTORes.class);
    }

    @Override
    public TestDTO deleteById(int id) {
        Test test = testRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("id : " + id));
        testRepository.deleteById(id);
        return modelMapper.map(test, TestDTO.class);
    }

    @Override
    public TestDTO update(TestDTO testDTO) {
        Test test = testRepository.findById(testDTO.getId())
                .orElseThrow(() -> new ResourceNotFoundException("id : " + testDTO.getId()));
        test.setSuccessScore(testDTO.getSuccessScore());
        test.setCanViewAnswers(testDTO.isCanViewAnswers());
        test.setCanSeeResult(testDTO.isCanSeeResult());
        test.setNumberOfChances(testDTO.getNumberOfChances());
        test.setRemarks(testDTO.getRemarks());
        test.setInstructions(testDTO.getInstructions());
        testRepository.save(test);
        return modelMapper.map(test, TestDTO.class);
    }
}
