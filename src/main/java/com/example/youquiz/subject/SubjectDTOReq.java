package com.example.youquiz.subject;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
public class SubjectDTOReq {
    private int id;
    private String title;
    private SubjectDTOReq parent;
}
