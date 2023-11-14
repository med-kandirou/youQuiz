package com.example.youquiz.test;

import com.example.youquiz.trainer.TrainerDTO;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.Setter;


@Getter
@Setter
@NoArgsConstructor
public class TestDTO {
    private Long id;
    @NonNull
    private int successScore;
    @NonNull private boolean canViewAnswers;
    @NonNull private boolean canSeeResult;
    @NonNull private int numberOfChances;
    @NonNull private String remarks;
    @NonNull private String instructions;
    @NonNull private TrainerDTO trainer;
}
