package com.example.youquiz.student;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IStudent {
    Page<StudentDTO> findAll(Pageable pageable);
    StudentDTO findById(int id);
    StudentDTO save(StudentDTO studentDTO);
    StudentDTO deleteById(int id);
    StudentDTO update(StudentDTO studentDTO);
}
