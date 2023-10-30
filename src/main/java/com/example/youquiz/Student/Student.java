package com.example.youquiz.Student;

import com.example.youquiz.Person.Person;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Getter
@Setter
@RequiredArgsConstructor
@NoArgsConstructor

@Entity
@Table
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
