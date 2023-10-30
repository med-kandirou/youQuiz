package com.example.youquiz.student;

import com.example.youquiz.person.Person;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;


@Data
@Entity
@Table
@RequiredArgsConstructor
@NoArgsConstructor
public class Student extends Person {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int code;
    @NonNull private LocalDate dateInscription;

    public Student(String firstName, String lastName, LocalDate birthday,String adresse,LocalDate dateInscription){
        super(firstName,lastName,birthday,adresse);
        this.dateInscription=dateInscription;
    }
}
