package com.example.youquiz.room;

import com.example.youquiz.student.Student;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

import java.time.LocalDate;

@Data
@Entity
@Table
@RequiredArgsConstructor
@NoArgsConstructor
public class Room {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @NonNull
    private LocalDate dateCreation;
    @NonNull
    private String title;
    @NonNull
    private String description;
    @ManyToOne
    private Student creator;
}