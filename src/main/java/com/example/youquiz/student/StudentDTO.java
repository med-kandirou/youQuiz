package com.example.youquiz.student;

import com.example.youquiz.person.Person;
import lombok.*;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor

public class StudentDTO extends Person {
    private int code;
    @NonNull private LocalDate dateInscription;
}
