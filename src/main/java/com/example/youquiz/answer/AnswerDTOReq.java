package com.example.youquiz.answer;


import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;


@Data
@NoArgsConstructor
@RequiredArgsConstructor
public class AnswerDTOReq {
    private int id;
    @NonNull private int validation_id;
    @NonNull private int assignment_id;
}
