package com.example.youquiz.assignment;

import lombok.*;

import java.time.LocalDate;

@Getter
@Setter
@RequiredArgsConstructor
@NoArgsConstructor
public class AssignementTDOReq {
    private long id;
    @NonNull private LocalDate dateStart;
    @NonNull private LocalDate dateEnd;
    @NonNull private double score;
    @NonNull private int trainer_id;
    @NonNull private int student_id;
}
