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
@Embeddable
public class Validation {
    @ManyToOne
    @NonNull private Question question;
    @ManyToOne
    @NonNull private Response response;
    @NonNull private Double point;
}
