package com.example.youquiz.media;


import com.example.youquiz.question.QuestionDTORes;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.springframework.lang.NonNull;



@Getter
@Setter
@RequiredArgsConstructor
@NoArgsConstructor
public class MediaDTORes {
    private int id;
    @NonNull private String src;
    @NonNull private MediaType mediaType;
    @NonNull private QuestionDTORes question;
}
