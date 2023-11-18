package com.example.youquiz.answer;

import com.example.youquiz.assignment.Assignment;
import com.example.youquiz.validation.Validation;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Data
@Entity
@Table
@NoArgsConstructor
@RequiredArgsConstructor
public class Answer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @ManyToOne
    @NonNull
    private Validation validation;
    @ManyToOne
    @NonNull private Assignment assignment;
}
