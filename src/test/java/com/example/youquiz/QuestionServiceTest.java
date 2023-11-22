package com.example.youquiz;

import com.example.youquiz.question.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.junit.jupiter.MockitoSettings;
import org.mockito.quality.Strictness;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.webjars.NotFoundException;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.when;

@MockitoSettings(strictness = Strictness.LENIENT)
@ExtendWith(MockitoExtension.class)
class QuestionServiceTest {
    @Mock
    private QuestionRepository questionRepository;

    @InjectMocks
    private QuestionService questionService;

    @Mock
    private ModelMapper modelMapper;


    private Question question;

    private QuestionDTOReq questionDto;

    private QuestionDTORes questionDtoRsp;

    private List<QuestionDTORes> questionDtoRsps;

    @BeforeEach
    public void setUp() {
        question = new Question();
        question.setId(1);
        question.setNumberOfResponses(1);

        questionDto = new QuestionDTOReq();
        questionDto.setId(1);
        questionDto.setNumberOfResponses(1);

        questionDtoRsp = new QuestionDTORes();
        questionDtoRsp.setId(1);
        questionDtoRsp.setNumberOfResponses(1);

    }

    @Test
    public void save() {

        try {
            when(questionService.save(questionDto)).thenReturn(questionDto);
            assertEquals(questionDto, questionService.save(questionDto));
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }

    @Test
    public void update() {
        try {
            given(questionRepository.findById(1)).willReturn(Optional.of(question));
            given(modelMapper.map(questionDto, Question.class)).willReturn(question);
            given(questionRepository.save(question)).willReturn(question);
            assertSame(questionDto.getId(), questionService.update(questionDto).getId());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    @Test
    public void findbyId() {

        given(questionRepository.findById(1)).willReturn(Optional.empty());
        assertThrows(RuntimeException.class, () -> questionService.findById(1));

    }

    @Test
    public void deleteTest() {
        try {
            given(questionRepository.findById(1)).willReturn(Optional.empty());
            assertThrows(RuntimeException.class, () -> questionService.deleteById(1));
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    @Test
    public void findAll() {
        Pageable pageable = PageRequest.of(0, 2);
        try {
            List<Question> questions = new ArrayList<>();
            questions.add(question);
            questions.add(question);
            questions.add(question);
            given(questionRepository.findAll()).willReturn(questions);
            assertEquals(3, questionService.findAll(pageable).getTotalElements());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    @Test
    public void findbySubjectId() {
        try {
            List<Question> questions = new ArrayList<>();
            questions.add(question);
            questions.add(question);
            questions.add(question);
            given(questionRepository.findBySubjectId(1)).willReturn(questions);
            assertEquals(3, questionService.findBySubjectId(1).size());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    @Test
    public void findbyLevelId() {
        try {
            List<Question> questions = new ArrayList<>();
            questions.add(question);
            questions.add(question);
            questions.add(question);
            given(questionRepository.findByLevelId(1)).willReturn(questions);
            assertEquals(3, questionService.findByLevelId(1).size());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
