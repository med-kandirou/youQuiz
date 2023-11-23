package com.example.youquiz.assignment;

import com.example.youquiz.Exception.RecordAlreadyExistsException;

import java.util.List;

public interface IAssignement {
    List<AssignementTDORes> findAll();
    AssignementTDORes findById(int id);
    AssignementTDOReq save(AssignementTDOReq assignementTDOReq) throws RecordAlreadyExistsException;
    AssignementTDORes deleteById(int id);
    AssignementTDOReq update(AssignementTDOReq assignementTDOReq);
}
