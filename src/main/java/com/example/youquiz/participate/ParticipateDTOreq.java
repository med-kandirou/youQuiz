package com.example.youquiz.participate;


import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
public class ParticipateDTOreq {
    @NotNull(message = "participateID cannot be null")
    private ParticipateID participateID;
    @NotNull(message = "Date of participation cannot be null")
    private LocalDate dateParticipation;
}
