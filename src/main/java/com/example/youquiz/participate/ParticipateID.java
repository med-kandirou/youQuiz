package com.example.youquiz.participate;

import com.example.youquiz.room.Room;
import com.example.youquiz.student.Student;
import jakarta.persistence.ManyToOne;
import lombok.Data;
import lombok.NoArgsConstructor;


import java.io.Serializable;

@Data
@NoArgsConstructor
public class ParticipateID implements Serializable {
    @ManyToOne
    private Student student;
    @ManyToOne
    private Room room;
}
