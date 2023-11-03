package com.example.youquiz.subject;

import com.example.youquiz.question.Question;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

import java.util.*;

@Data
@Entity
@Table
@NoArgsConstructor
@RequiredArgsConstructor
public class Subject {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @NonNull
    private String intitule;
    @ManyToOne
    private Subject parent;

    @OneToMany(mappedBy = "subject",fetch = FetchType.EAGER)
    private Set<Question> questions= new HashSet<>(){};
}
