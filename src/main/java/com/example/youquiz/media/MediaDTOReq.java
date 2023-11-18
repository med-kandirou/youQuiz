package com.example.youquiz.media;

import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
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
//@RequiredArgsConstructor
@NoArgsConstructor
public class MediaDTOReq {
    private int id;
    @NotBlank(message = "Source is required")
    private String src;

    @Enumerated(EnumType.STRING)
    @NotNull(message = "MediaType cannot be null")
    private MediaType mediaType;

    @NotNull(message = "question_id is required")
    private Integer question_id;
}
