package com.example.youquiz.student;

import com.example.youquiz.person.Person;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor

public class StudentDTO extends Person {
    private int code;
    @NotBlank(message = "Date Inscription is required")
    @NonNull private LocalDate dateInscription;
}
