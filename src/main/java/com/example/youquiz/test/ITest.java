package com.example.youquiz.test;


import java.util.List;

public interface ITest {
    List<TestDTO> findAll();
    TestDTO findById(int id);
    TestDTOReq save(TestDTOReq testDTOReq);
    TestDTO deleteById(int id);
    TestDTO update(TestDTO testDTO);
}
