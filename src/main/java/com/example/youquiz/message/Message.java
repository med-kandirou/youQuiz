package com.example.youquiz.message;


import com.example.youquiz.media.MediaType;
import com.example.youquiz.participate.Participate;
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
public class Message {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @NonNull
    private String content;
    @ManyToOne
    @NonNull
    private Participate participate;
}
