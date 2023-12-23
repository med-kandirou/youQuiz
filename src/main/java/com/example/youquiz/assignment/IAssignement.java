package com.example.youquiz.assignment;

import com.example.youquiz.Exception.RecordAlreadyExistsException;
import com.example.youquiz.student.Student;
import com.example.youquiz.temporisation.Temporisation;
import com.example.youquiz.test.Test;

import java.util.List;

public interface IAssignement {
    List<AssignementTDORes> findAll();
    AssignementTDORes findById(int id);
    AssignementTDOReq save(AssignementTDOReq assignementTDOReq) throws RecordAlreadyExistsException;
    AssignementTDORes deleteById(int id);
    AssignementTDOReq update(AssignementTDOReq assignementTDOReq);
    List<AssignementTDORes> findByStudent(int studendId,boolean isPassed);

}
