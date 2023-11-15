package com.example.youquiz.question;

import com.example.youquiz.response.ResponseDTO;

import java.util.List;

public interface IQuestion {
    List<QuestionDTORes> findAll();
    QuestionDTORes findById(int id);
    QuestionDTOReq save(QuestionDTOReq questionDTOReq);
    QuestionDTORes deleteById(int id);
    QuestionDTOReq update(QuestionDTOReq questionDTOReq);
}
