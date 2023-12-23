package com.example.youquiz.validation;

import com.example.youquiz.question.QuestionDTORes;
import com.example.youquiz.response.ResponseDTO;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Data
@NoArgsConstructor
@RequiredArgsConstructor
public class ValidationDTORes {
    private int id;
    //@NonNull private double point;
    @NonNull private ResponseDTO response;
    @NonNull private QuestionDTORes question;
}
