package com.example.youquiz.validation;

import com.example.youquiz.answer.Answer;
import com.example.youquiz.question.Question;
import com.example.youquiz.response.Response;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

import java.util.List;

@Entity
@Data
@NoArgsConstructor
@RequiredArgsConstructor
public class Validation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @NonNull
    private double point;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "Response_id")
    @NonNull
    private Response response;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "Question_id")
    @NonNull
    private Question question;


    @OneToMany(fetch = FetchType.LAZY)
    private List<Answer> answers;
}
