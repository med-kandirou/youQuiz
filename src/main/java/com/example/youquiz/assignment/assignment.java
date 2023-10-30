package com.example.youquiz.assignment;

import com.example.youquiz.student.Student;
import com.example.youquiz.trainer.Trainer;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import java.time.LocalDate;


@Data
@Entity
@Table
@NoArgsConstructor
@RequiredArgsConstructor
public class assignment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @NonNull private LocalDate dateStart;
    @NonNull private LocalDate dateEnd;
    @Transient
    @NonNull private LocalDate dure;
    @NonNull private double score;

    @OneToOne
    @NonNull private Trainer trainer;

    @OneToOne
    @NonNull private Student student;
}
