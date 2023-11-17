package com.example.youquiz.temporisation;


import com.example.youquiz.question.QuestionDTORes;
import com.example.youquiz.test.TestDTO;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;


@Data
@NoArgsConstructor
@RequiredArgsConstructor
public class TemporisationDTORes {
    private int id;
    @NonNull
    private int time;
    @NonNull
    private TestDTO test;
    @NonNull
    private QuestionDTORes question;
}
