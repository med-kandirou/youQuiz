package com.example.youquiz.subject;


import lombok.*;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
public class SubjectDTOResp {
    private int id;
    private String title;
    private SubjectDTOReq parent;
    //private List<SubjectDTOReq> children;
}
