package com.example.youquiz.question;


import com.example.youquiz.level.Level;
import com.example.youquiz.response.Response;
import com.example.youquiz.subject.Subject;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

import java.util.HashSet;
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

    @ManyToOne
    @NonNull private Level level;

}



