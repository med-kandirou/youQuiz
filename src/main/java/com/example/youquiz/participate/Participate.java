package com.example.youquiz.participate;


import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

import java.time.LocalDate;


@Data
@Entity
@Table
@RequiredArgsConstructor
@NoArgsConstructor
public class Participate {
    @EmbeddedId
    @NonNull
    private ParticipateID participateID;
    @NonNull
    private LocalDate dateParticipation;
}
