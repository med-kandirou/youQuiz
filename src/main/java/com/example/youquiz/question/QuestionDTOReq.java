package com.example.youquiz.question;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
//@RequiredArgsConstructor
public class QuestionDTOReq {
    private int id;

    @NotNull(message = "numberOfResponses is required")
    private Integer numberOfResponses;

    @NotNull(message = "numberOfCorrectResponses is required")
    private Integer numberOfCorrectResponses;

    @NotBlank(message = "Question text is required")
    private String questionText;

    @NotNull(message = "Question type is required")
    private QuestionType type;

    @Min(value = 0, message = "Subject ID must be greater than or equal to 0")
    private int subject_id;

    @Min(value = 0, message = "Level ID must be greater than or equal to 0")
    private int level_id;
}
