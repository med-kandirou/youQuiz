package com.example.youquiz.validation;

import com.example.youquiz.question.Question;
import com.example.youquiz.response.Response;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Data
@NoArgsConstructor
@RequiredArgsConstructor
public class ValidationDTORes {
    private int id;
    @NonNull private double point;
    @NonNull private Response response;
    @NonNull private Question question;
}
