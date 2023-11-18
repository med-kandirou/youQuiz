package com.example.youquiz.response;

import jakarta.validation.constraints.NotBlank;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@RequiredArgsConstructor
public class ResponseDTO {
    private int id;

    @NonNull
    @NotBlank(message = "Text response is required")
    private String textResponse;

}