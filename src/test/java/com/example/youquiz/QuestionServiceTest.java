package com.example.youquiz;

import com.example.youquiz.Exception.ResourceNotFoundException;
import com.example.youquiz.level.Level;
import com.example.youquiz.level.LevelRepository;
import com.example.youquiz.question.*;
import com.example.youquiz.subject.Subject;
import com.example.youquiz.subject.SubjectRepository;
import com.example.youquiz.test.TestDTO;
import jakarta.validation.constraints.AssertTrue;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@SpringBootTest
@ExtendWith(MockitoExtension.class)
class QuestionServiceTest {

    @Mock
    private ModelMapper modelMapper;

    @Mock
    private QuestionRepository questionRepository;

    @Mock
    private LevelRepository levelRepository;

    @Mock
    private SubjectRepository subjectRepository;

    @InjectMocks
    private QuestionService questionService;

    @BeforeEach
    void setUp() {
        // Set up any initial data or configurations for your tests
    }

    @Test
    void findAll() {
        // Mock data
        Question question1 = new Question();
        Question question2 = new Question();
        List<Question> questionList = Arrays.asList(question1, question2);

        // Mock repository behavior
        when(questionRepository.findAll()).thenReturn(questionList);

        // Perform the service call
        List<QuestionDTORes> result = questionService.findAll();

        // Verify the result
        assertEquals(2, result.size());
        // Add more assertions based on your specific requirements
    }

    @Test
    void save() {
        Subject subject = new Subject();
        subject.setId(1);
        Level level = new Level();
        level.setId(2);
        QuestionDTOReq questionDTOReq = new QuestionDTOReq();
        questionDTOReq.setSubject_id(1);
        questionDTOReq.setLevel_id(2);

        when(subjectRepository.findById(1)).thenReturn(Optional.of(subject));
        when(levelRepository.findById(2)).thenReturn(Optional.of(level));

        QuestionDTOReq result = questionService.save(questionDTOReq);

        //AssertTrue(result,modelMapper.map(result, QuestionDTOReq.class));
    }

    @Test
    void deleteById() {
        // Mock data
        Question question = new Question();
        question.setId(1);

        // Mock repository behavior
        when(questionRepository.findById(1)).thenReturn(Optional.of(question));

        // Perform the service call
        QuestionDTORes result = questionService.deleteById(1);

        // Verify the result
        assertEquals(1, result.getId());
        // Add more assertions based on your specific requirements
    }

    @Test
    void findBySubjectId() {
        // Mock data
        Question question1 = new Question();
        Question question2 = new Question();
        List<Question> questionList = Arrays.asList(question1, question2);

        // Mock repository behavior
        when(questionRepository.findBySubjectId(1)).thenReturn(questionList);

        // Perform the service call
        List<QuestionDTORes> result = questionService.findBySubjectId(1);

        // Verify the result
        assertEquals(2, result.size());
        // Add more assertions based on your specific requirements
    }

    @Test
    void findByLevelId() {
        // Mock data
        Question question1 = new Question();
        Question question2 = new Question();
        List<Question> questionList = Arrays.asList(question1, question2);

        // Mock repository behavior
        when(questionRepository.findByLevelId(2)).thenReturn(questionList);

        // Perform the service call
        List<QuestionDTORes> result = questionService.findByLevelId(2);

        // Verify the result
        assertEquals(2, result.size());
        // Add more assertions based on your specific requirements
    }
}
