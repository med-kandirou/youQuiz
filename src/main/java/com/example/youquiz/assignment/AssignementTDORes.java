package com.example.youquiz.assignment;

import com.example.youquiz.student.Student;
import com.example.youquiz.student.StudentDTO;
import com.example.youquiz.test.Test;
import com.example.youquiz.test.TestDTO;
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
    @NonNull private TestDTO test;
    @NonNull private StudentDTO student;
}
