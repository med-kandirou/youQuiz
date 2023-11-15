package com.example.youquiz.response;

import com.example.youquiz.question.Question;
import com.example.youquiz.validation.Validation;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import java.util.HashSet;
import java.util.Set;

@Data
@Entity
@Table
@NoArgsConstructor
@RequiredArgsConstructor
public class Response {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @NonNull
    private String textResponse;

    @ManyToMany
    private Set<Validation> validations = new HashSet<>();
}
