package com.example.youquiz.trainer;

import com.example.youquiz.person.Person;
import com.example.youquiz.test.Test;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

import java.time.LocalDate;
import java.util.List;


@Data
@Entity
@Table
@RequiredArgsConstructor
@NoArgsConstructor
public class Trainer extends Person {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int matricule;
    @NotBlank(message = "specialite is required")
    @NonNull private String specialite;

    public Trainer(String firstName, String lastName, LocalDate birthday,String adresse,String specialite){
        super(firstName,lastName,birthday,adresse);
        this.specialite=specialite;
    }

    @OneToMany(mappedBy = "trainer", cascade = CascadeType.ALL)
    private List<Test> tests;

}
