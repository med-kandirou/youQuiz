package com.example.youquiz;

import com.example.youquiz.Exception.ResourceNotFoundException;
import com.example.youquiz.level.Level;
import com.example.youquiz.level.LevelRepository;
import com.example.youquiz.question.*;
import com.example.youquiz.subject.Subject;
import com.example.youquiz.subject.SubjectRepository;
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


    @InjectMocks
    private QuestionService questionService;

    @BeforeEach
    private void init(){
    }

    @Test
    void findAll() {
        Question question1 = new Question();
        Question question2 = new Question();
        List<Question> questionList = Arrays.asList(question1, question2);

        when(questionRepository.findAll()).thenReturn(questionList);

        List<QuestionDTORes> result = questionService.findAll();

        assertEquals(2, result.size());
    }


    @Test
    void findBySubjectId() {
        Question question1 = new Question();
        Question question2 = new Question();
        List<Question> questionList = Arrays.asList(question1, question2);

        when(questionRepository.findBySubjectId(1)).thenReturn(questionList);

        List<QuestionDTORes> result = questionService.findBySubjectId(1);

        assertEquals(2, result.size());

    }

    @Test
    void findByLevelId() {
        Question question1 = new Question();
        Question question2 = new Question();
        List<Question> questionList = Arrays.asList(question1, question2);
        when(questionRepository.findByLevelId(2)).thenReturn(questionList);

        List<QuestionDTORes> result = questionService.findByLevelId(2);

        assertEquals(2, result.size());
    }
}
