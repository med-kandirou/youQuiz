package com.example.youquiz.Person;


import jakarta.persistence.MappedSuperclass;
import lombok.*;

import java.time.LocalDate;

@Getter
@Setter
@RequiredArgsConstructor
@NoArgsConstructor
@MappedSuperclass
public class Person {
    @NonNull protected String firstName;
    @NonNull protected String lastName;
    @NonNull protected LocalDate birthday;
    @NonNull private String adresse;
}
