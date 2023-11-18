package com.example.youquiz.test;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;


@Getter
@Setter
@NoArgsConstructor

public class TestDTOReq {
    private int id;
    @NotNull(message = "Success score is required")
    private Integer successScore;

    @NotNull(message = "Can view answers is required")
    private Boolean canViewAnswers;

    @NotNull(message = "Can see result is required")
    private Boolean canSeeResult;

    @NotNull(message = "Number of chances is required")
    @Min(value = 1, message = "Number of chances must be at least 1")
    private Integer numberOfChances;

    @NotBlank(message = "Remarks is required")
    private String remarks;

    @NotBlank(message = "Instructions is required")
    private String instructions;

    @NotNull(message = "Trainer matricule is required")
    private Integer trainer_matricule;

}
