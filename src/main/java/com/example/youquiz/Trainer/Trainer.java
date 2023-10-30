package com.example.youquiz.Trainer;

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
public class Trainer extends Person {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int matricule;
    @NonNull private String specialite;

    public Trainer(String firstName, String lastName, LocalDate birthday,String adresse,String specialite){
        super(firstName,lastName,birthday,adresse);
        this.specialite=specialite;
    }

}
