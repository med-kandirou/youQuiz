package com.example.youquiz.level;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.springframework.lang.NonNull;


@Getter
@Setter
@NoArgsConstructor
//@RequiredArgsConstructor
public class LevelDTO {
    private int id;
    @NotEmpty(message = "Description is required")
    private String description;

    @NotNull(message = "pointMin is required")
    private Integer pointMin;

    @Min(value=0,message = "pointMax is required to be > 0")
    private Integer pointMax;
}
