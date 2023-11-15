package com.example.youquiz.response;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@RequiredArgsConstructor
public class ResponseDTO {
    private int id;
    @NonNull
    private String textResponse;

}