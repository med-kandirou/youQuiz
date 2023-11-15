package com.example.youquiz.test;


import java.util.List;

public interface ITest {
    List<TestDTO> findAll();
    TestDTO findById(int id);
    TestDTORes save(TestDTORes testDTORes);
    TestDTO deleteById(int id);
    TestDTO update(TestDTO testDTO);
}
