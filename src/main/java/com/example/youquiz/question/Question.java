package com.example.youquiz.question;


import com.example.youquiz.level.Level;
import com.example.youquiz.subject.Subject;
import com.example.youquiz.validation.Validation;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Data
@NoArgsConstructor
@RequiredArgsConstructor
public class Question {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @NonNull private int numberOfResponses;
    @NonNull private int numberOfCorrectResponses;
    @NonNull private String questionText;
    @NonNull private String image;

    @ManyToOne
    @NonNull private Subject subject;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @NonNull private Level level;


    @OneToMany(mappedBy = "question", fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Validation> validations;

}



