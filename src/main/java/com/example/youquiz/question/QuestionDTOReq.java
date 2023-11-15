package com.example.youquiz.question;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@RequiredArgsConstructor
public class QuestionDTOReq {
    private int id;
    @NonNull private int numberOfResponses;
    @NonNull private int numberOfCorrectResponses;
    @NonNull private String questionText;
    @NonNull private QuestionType type;
    @NonNull private int subject_id;
    @NonNull private int level_id;
}
