package com.example.youquiz.media;

import com.example.youquiz.question.Question;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.springframework.lang.NonNull;

@Entity
@Getter
@Setter
@RequiredArgsConstructor
@NoArgsConstructor
public class Media {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @NonNull private String src;
    @Enumerated(EnumType.STRING)
    @NonNull private MediaType mediaType;

    @ManyToOne
    @NonNull private Question question;
}
