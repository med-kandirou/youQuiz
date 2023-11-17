package com.example.youquiz.temporisation;


import java.util.List;

public interface ITemporisation {
    List<TemporisationDTORes> findAll();
    TemporisationDTORes findById(int id);
    TemporisationDTOReq save(TemporisationDTOReq temporisationDTOReq);
    TemporisationDTOReq deleteById(int id);
    TemporisationDTOReq update(TemporisationDTOReq temporisationDTOReq);
}
