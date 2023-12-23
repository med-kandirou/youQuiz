package com.example.youquiz.assignment;

import jakarta.validation.constraints.NotNull;
import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Getter
@Setter
//@RequiredArgsConstructor
@NoArgsConstructor
public class AssignementTDOReq {
    private Integer id;

    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    @NotNull(message = "Date end is required")
    private LocalDateTime dateStart;

    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    @NotNull(message = "Date end is required")
    private LocalDateTime dateEnd;

    @NotNull(message = "score is required")
    private Double score;

    @NotNull(message = "result is required")
    @NonNull private boolean result;

    @NotNull(message = "isPassed is required")
    @NonNull private boolean passed;

    @NotNull(message = "Test ID is required")
    private Integer test_id;

    @NotNull(message = "Student ID is required")
    private Integer student_id;
}
