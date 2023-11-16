package com.example.youquiz.assignment;

import java.util.List;

public interface IAssignement {
    List<AssignementTDORes> findAll();
    AssignementTDORes findById(int id);
    AssignementTDOReq save(AssignementTDOReq assignementTDOReq);
    AssignementTDORes deleteById(int id);
    AssignementTDOReq update(AssignementTDOReq assignementTDOReq);
}
