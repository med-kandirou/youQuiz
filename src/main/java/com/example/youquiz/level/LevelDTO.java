package com.example.youquiz.level;

import com.example.youquiz.question.Question;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.springframework.lang.NonNull;


@Getter
@Setter
@NoArgsConstructor
@RequiredArgsConstructor
public class LevelDTO {
    private int id;
    @NonNull private String description;
    @NonNull private int pointMin;
    @NonNull private int pointMax;
}
