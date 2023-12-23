package com.example.youquiz.assignment;

import com.example.youquiz.answer.Answer;
import com.example.youquiz.student.Student;
import com.example.youquiz.test.Test;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;


@Data
@Entity
@Table
@NoArgsConstructor
@RequiredArgsConstructor
public class Assignment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @NonNull private LocalDateTime dateStart;
    @NonNull private LocalDateTime dateEnd;
    @Transient
    @NonNull private LocalDate dure;
    @NonNull private double score;
    @NonNull private boolean result;
    @NonNull private boolean passed;
    @ManyToOne
    @JoinColumn(name = "test_id")
    private Test test;
    @ManyToOne
    @JoinColumn(name = "student_id")
    private Student student;


    @OneToMany(fetch = FetchType.LAZY)
    private List<Answer> answers;
}
