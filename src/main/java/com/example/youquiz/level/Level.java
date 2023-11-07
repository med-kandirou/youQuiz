package com.example.youquiz.level;

import com.example.youquiz.question.Question;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.lang.NonNull;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table
@Data
@NoArgsConstructor
@RequiredArgsConstructor
public class Level {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @NonNull private String description;
    @NonNull private int pointMin;
    @NonNull private int pointMax;

    @OneToMany(mappedBy = "level",fetch = FetchType.EAGER)
    private Set<Question> questions;
}
