package com.example.youquiz.test;

import com.example.youquiz.trainer.Trainer;
import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@Entity
@Table
@NoArgsConstructor
@RequiredArgsConstructor
public class Test {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @NonNull private int successScore;
    @NonNull private boolean canViewAnswers;
    @NonNull private boolean canSeeResult;
    @NonNull private int numberOfChances;
    @NonNull private String remarks;
    @NonNull private String instructions;

    @ManyToOne
    @NonNull private Trainer trainer;

}
