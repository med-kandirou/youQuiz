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
public class Person {
    @NotBlank(message = "firstName is required")
    @NonNull protected String firstName;
    @NotBlank(message = "lastName is required")
    @NonNull protected String lastName;

    @NonNull protected LocalDate birthday;
    @NotBlank(message = "adresse is required")
    @NonNull private String adresse;
}
