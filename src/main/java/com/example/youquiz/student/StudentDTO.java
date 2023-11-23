package com.example.youquiz.student;

import com.example.youquiz.person.Person;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor

public class StudentDTO extends Person {
    private int code;
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    @NotNull(message = "dateInscription is required")
    @NonNull private LocalDate dateInscription;
}
