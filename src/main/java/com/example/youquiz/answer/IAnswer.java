package com.example.youquiz.answer;


import java.util.List;

public interface IAnswer {
    List<AnswerDTORes> findAll();
    AnswerDTORes findById(int id);
    AnswerDTOReq save(AnswerDTOReq answerDTOReq);
    AnswerDTORes deleteById(int id);
    AnswerDTOReq update(AnswerDTOReq answerDTOReq);
}
