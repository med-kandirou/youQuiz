package com.example.youquiz.temporisation;

import com.example.youquiz.question.Question;
import com.example.youquiz.test.Test;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Entity
@Table
@Data
@RequiredArgsConstructor
@NoArgsConstructor
public class Temporisation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @NonNull
    private int time;
    @ManyToOne
    @NonNull
    private Test test;
    @ManyToOne
    @NonNull
    private Question question;
}



