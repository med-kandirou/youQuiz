package com.example.youquiz.trainer;


import com.example.youquiz.person.Person;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class TrainerDTO extends Person {
    private int matricule;
    @NonNull
    private String specialite;
}
