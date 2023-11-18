package com.example.youquiz.validation;

import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Data
@NoArgsConstructor
//@RequiredArgsConstructor
public class ValidationDTOReq {
    private int id;

    @NotNull(message = "Point cannot be null")
    private Double point;

    @NotNull(message = "Response ID cannot be null")
    private Integer response_id;

    @NotNull(message = "Question ID cannot be null")
    private Integer question_id;
}
