package com.example.youquiz.test;

import com.example.youquiz.student.StudentDTO;

import java.util.List;

public interface ITest {
    List<TestDTO> findAll();
    TestDTO findById(int id);
    TestDTO save(TestDTO testDTO);
    TestDTO deleteById(int id);
    TestDTO update(TestDTO testDTO);
}
