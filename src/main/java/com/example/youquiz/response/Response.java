package com.example.youquiz.response;

import com.example.youquiz.validation.Validation;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

import java.util.List;

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
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "response", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Validation> validations;
}
