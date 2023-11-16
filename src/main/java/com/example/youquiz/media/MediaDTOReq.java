package com.example.youquiz.media;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.springframework.lang.NonNull;

@Getter
@Setter
@RequiredArgsConstructor
@NoArgsConstructor
public class MediaDTOReq {
    private int id;
    @NonNull private String src;
    @NonNull private MediaType mediaType;
    @NonNull private int question_id;
}
