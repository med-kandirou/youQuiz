package com.example.youquiz.room;

import com.example.youquiz.student.StudentDTO;

import lombok.*;

import java.time.LocalDate;


@Getter
@Setter
@NoArgsConstructor
public class RoomDTOres {
    private int id;
    private LocalDate dateCreation;
    private String title;
    private String description;
    private StudentDTO creator;
}
