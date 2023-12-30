package com.example.youquiz.participate;


import com.example.youquiz.room.RoomDTOres;

import java.util.List;

public interface IParticipate {
    List<ParticipateDTOres> findAll();
    ParticipateDTOres findById(ParticipateID id);
    ParticipateDTOres save(ParticipateDTOreq participateDTOreq);
    ParticipateDTOres deleteById(ParticipateID id);
    ParticipateDTOres update(ParticipateDTOreq participateDTOreq);
    List<RoomDTOres> findParticipatesByStudent(Integer studentId, String status);
}
