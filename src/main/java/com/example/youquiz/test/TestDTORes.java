package com.example.youquiz.test;

import lombok.*;


@Getter
@Setter
@NoArgsConstructor

public class TestDTORes {
    private int id;
    @NonNull private int successScore;
    @NonNull private boolean canViewAnswers;
    @NonNull private boolean canSeeResult;
    @NonNull private int numberOfChances;
    @NonNull private String remarks;
    @NonNull private String instructions;
    @NonNull private int trainer_matricule; // Use trainerId instead of TrainerDTO

}
