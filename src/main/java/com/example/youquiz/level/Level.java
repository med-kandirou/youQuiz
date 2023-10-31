package com.example.youquiz.level;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.lang.NonNull;


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
}
