package com.example.youquiz.temporisation;


import com.example.youquiz.Exception.RecordAlreadyExistsException;

import java.util.List;

public interface ITemporisation {
    List<TemporisationDTORes> findAll();
    TemporisationDTORes findById(int id);
    TemporisationDTOReq save(TemporisationDTOReq temporisationDTOReq) throws RecordAlreadyExistsException;
    TemporisationDTOReq deleteById(int id);
    TemporisationDTOReq update(TemporisationDTOReq temporisationDTOReq);
}
