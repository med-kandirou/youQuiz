package com.example.youquiz.subject;

import jakarta.validation.constraints.NotNull;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
public class SubjectDTOReq {
    private int id;
    @NotNull(message = "title is required")
    private String title;
    private Integer parent_id;
}
