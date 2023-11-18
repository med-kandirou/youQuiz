package com.example.youquiz.assignment;

import jakarta.validation.constraints.NotNull;
import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;

@Getter
@Setter
//@RequiredArgsConstructor
@NoArgsConstructor
public class AssignementTDOReq {
    private Integer id;

    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    @NotNull(message = "Date end is required")
    private LocalDate dateStart;

    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    @NotNull(message = "Date end is required")
    private LocalDate dateEnd;

    @NotNull(message = "score is required")
    private Double score;

    @NotNull(message = "Test ID is required")
    private Integer test_id;

    @NotNull(message = "Student ID is required")
    private Integer student_id;
}
