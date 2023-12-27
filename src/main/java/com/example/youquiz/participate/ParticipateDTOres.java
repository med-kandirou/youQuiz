package com.example.youquiz.participate;


import lombok.*;

import java.time.LocalDate;


@Getter
@Setter
@NoArgsConstructor
public class ParticipateDTOres {
    @NonNull
    private ParticipateID participateID;
    @NonNull
    private LocalDate dateParticipation;
}
