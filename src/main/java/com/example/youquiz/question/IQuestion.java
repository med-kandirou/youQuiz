package com.example.youquiz.question;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IQuestion {
    List<QuestionDTORes> all();
    Page<QuestionDTORes> findAll(Pageable pageable);
    QuestionDTORes findById(int id);
    QuestionDTOReq save(QuestionDTOReq questionDTOReq);
    QuestionDTORes deleteById(int id);
    QuestionDTOReq update(QuestionDTOReq questionDTOReq);
}
