package com.example.youquiz.answer;


import com.example.youquiz.assignment.AssignementTDORes;
import com.example.youquiz.assignment.Assignment;
import com.example.youquiz.validation.Validation;

import com.example.youquiz.validation.ValidationDTORes;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Data
@NoArgsConstructor
@RequiredArgsConstructor
public class AnswerDTORes {
    private int id;
    @NonNull private ValidationDTORes validation;
    @NonNull private AssignementTDORes assignment;
}
