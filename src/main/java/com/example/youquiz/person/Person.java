package com.example.youquiz.person;


import jakarta.persistence.MappedSuperclass;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;
import java.time.LocalDate;

@Getter
@Setter
@RequiredArgsConstructor
@NoArgsConstructor
@MappedSuperclass
public abstract class Person {
    @NotBlank(message = "firstName is required")
    @NonNull protected String firstName;
    @NotBlank(message = "lastName is required")
    @NonNull protected String lastName;

    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    @NotNull(message = "birthday is required")
    @NonNull protected LocalDate birthday;

    @NotBlank(message = "adresse is required")
    @NonNull private String adresse;
}
