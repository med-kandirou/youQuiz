package com.example.youquiz.temporisation;


import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Data
@NoArgsConstructor
@RequiredArgsConstructor
public class TemporisationDTOReq {
    private int id;
    @NonNull
    private int time;
    @NonNull
    private int test_id;
    @NonNull
    private int question_id;
}
