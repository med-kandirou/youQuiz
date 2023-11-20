package com.example.youquiz;

import com.example.youquiz.question.QuestionDTOReq;
import com.example.youquiz.question.QuestionDTORes;
import com.example.youquiz.question.QuestionService;
import com.example.youquiz.question.QuestionType;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.junit.jupiter.MockitoSettings;
import org.mockito.quality.Strictness;
import org.webjars.NotFoundException;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.when;

@MockitoSettings(strictness = Strictness.LENIENT)
class QuestionServiceTest {
    @Mock
    private QuestionService questionService;
    private QuestionDTOReq questionDTO;
    private QuestionDTOReq questionResponseDTO;
    @BeforeEach
    private void init(){
        questionDTO = new QuestionDTOReq();
        questionDTO.setId(1);
        questionDTO.setType(QuestionType.MulipleAnswer);
        questionDTO.setQuestionText("test");
        questionDTO.setNumberOfResponses(1);
        questionDTO.setNumberOfCorrectResponses(1);

        questionResponseDTO = new QuestionDTOReq();
        questionResponseDTO.setId(1);
        questionResponseDTO.setQuestionText("test");
        questionResponseDTO.setNumberOfResponses(1);
        questionResponseDTO.setNumberOfCorrectResponses(1);

    }

    @Test
    void save() {
        try{
            when(questionService.save(questionDTO)).thenReturn(questionResponseDTO);
            QuestionDTOReq tmp = questionService.save(questionDTO);
            assertEquals(questionDTO.getId(), tmp.getId());
        }catch (NotFoundException ex){}
    }

    @Test
    void update() {
        try{
            questionDTO.setQuestionText("test*");
            when(questionService.update(questionDTO)).thenReturn(questionResponseDTO);
            QuestionDTOReq tmp = questionService.update(questionDTO);
            assertEquals(questionDTO.getId(), tmp.getId());
            assertEquals(questionDTO.getNumberOfResponses(), tmp.getNumberOfResponses());
        }catch (NotFoundException ex){}
    }


    @Test
    void findAll() {
        List<QuestionDTORes> list = new ArrayList<>();
        when(questionService.findAll()).thenReturn(list);
        assertEquals(0, list.size());
    }

    @Test
    void findBySubjectId() {
        QuestionDTORes questionDTORes1 = new QuestionDTORes();
        QuestionDTORes questionDTORes2 = new QuestionDTORes();
        List<QuestionDTORes> list = new ArrayList<>();
        list.add(questionDTORes1);
        list.add(questionDTORes2);
        when(questionService.findBySubjectId(1)).thenReturn(list);
        assertEquals(2, list.size());
    }

    @Test
    void findByLevelId() {
        QuestionDTORes questionDTORes1 = new QuestionDTORes();
        List<QuestionDTORes> list = new ArrayList<>();
        list.add(questionDTORes1);
        when(questionService.findByLevelId(1)).thenReturn(list);
        assertEquals(1, list.size());
    }
}