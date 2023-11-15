package com.example.youquiz.validation;

import com.example.youquiz.question.Question;
import com.example.youquiz.response.Response;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;


@Entity
@Data
@NoArgsConstructor
@RequiredArgsConstructor
public class Validation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "Response_id")
    @NonNull
    private Response response;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "Question_id")
    @NonNull
    private Question question;

    @Column(nullable = false)
    @NonNull
    private double point;
}
