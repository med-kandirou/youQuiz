package com.example.youquiz.assignment;

import com.example.youquiz.student.Student;
import com.example.youquiz.student.StudentDTO;
import com.example.youquiz.trainer.TrainerDTO;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Getter
@Setter
@RequiredArgsConstructor
@NoArgsConstructor
public class AssignementTDORes {
    private long id;
    @NonNull
    private LocalDate dateStart;
    @NonNull private LocalDate dateEnd;
    @NonNull private double score;
    @NonNull private TrainerDTO trainer;
    @NonNull private StudentDTO student;
}
