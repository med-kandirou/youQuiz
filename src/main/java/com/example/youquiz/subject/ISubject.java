package com.example.youquiz.subject;


import java.util.List;

public interface ISubject {
    List<SubjectDTOResp> findAll();
    SubjectDTOResp findById(int id);
    SubjectDTOReq save(SubjectDTOReq subjectDTOReq);
    SubjectDTOResp deleteById(int id);
    SubjectDTOReq update(SubjectDTOReq subjectDTOReq);
}
