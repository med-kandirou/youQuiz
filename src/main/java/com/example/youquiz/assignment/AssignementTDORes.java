package com.example.youquiz.assignment;


import com.example.youquiz.student.StudentDTO;
import com.example.youquiz.test.TestDTO;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Getter
@Setter
@RequiredArgsConstructor
@NoArgsConstructor
public class AssignementTDORes {
    private long id;
    @NonNull
    private LocalDateTime dateStart;
    @NonNull private LocalDateTime dateEnd;
    @NonNull private double score;
    @NonNull private boolean result;
    @NonNull private boolean passed;
    @NonNull private TestDTO test;
    @NonNull private StudentDTO student;
}
