package com.example.youquiz.trainer;

import com.example.youquiz.person.Person;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;


@Entity
@Table
@Data
@NoArgsConstructor
@RequiredArgsConstructor
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
