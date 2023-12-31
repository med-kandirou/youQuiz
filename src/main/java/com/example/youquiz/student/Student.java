package com.example.youquiz.student;

import com.example.youquiz.assignment.Assignment;
import com.example.youquiz.person.Person;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.util.List;


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
    @NonNull private String password;
    /*@OneToMany(mappedBy = "student", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<Assignment> assignments;*/

    public Student(String firstName, String lastName, LocalDate birthday,String adresse,LocalDate dateInscription,String password){
        super(firstName,lastName,birthday,adresse);
        this.dateInscription=dateInscription;
        this.password=password;
    }
}
