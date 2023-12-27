package com.example.youquiz.message;


import com.example.youquiz.participate.ParticipateDTOres;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class MessageDTOres {
    private int id;
    private String content;
    private ParticipateDTOres participate;
}
