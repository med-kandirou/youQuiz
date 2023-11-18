package com.example.youquiz.answer;


import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;


@Data
@NoArgsConstructor
//@RequiredArgsConstructor
public class AnswerDTOReq {
    private int id;
    @NotNull(message = "validation_id is required")
    private Integer validation_id;
    @NotNull(message = "assignment_id is required")
    private Integer assignment_id;
}
