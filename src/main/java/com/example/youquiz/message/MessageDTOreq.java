package com.example.youquiz.message;

import com.example.youquiz.participate.ParticipateDTOres;
import com.example.youquiz.participate.ParticipateID;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
public class MessageDTOreq {
    private int id;
    @NotNull(message = "content is required")
    private String content;
    @NotNull(message = "participate is required")
    private ParticipateID participateID;
}
