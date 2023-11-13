package com.example.youquiz.student;

import java.util.List;

public interface IStudent {
    List<StudentDTO> findAll();
    StudentDTO findById(int id);
    StudentDTO save(StudentDTO studentDTO);
    StudentDTO deleteById(int id);
    StudentDTO update(StudentDTO studentDTO);
}
