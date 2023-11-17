package com.example.youquiz.validation;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Data
@NoArgsConstructor
@RequiredArgsConstructor
public class ValidationDTOReq {
    private int id;
    @NonNull private double point;
    @NonNull private int response_id;
    @NonNull private int question_id;
}
