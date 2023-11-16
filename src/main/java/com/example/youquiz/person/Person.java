package com.example.youquiz.person;


import jakarta.persistence.MappedSuperclass;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

import java.time.LocalDate;

@Getter
@Setter
@RequiredArgsConstructor
@NoArgsConstructor
@MappedSuperclass
public abstract class Person {
    @NonNull protected String firstName;
    @NonNull protected String lastName;
    @NonNull protected LocalDate birthday;
    @NonNull private String adresse;
}
