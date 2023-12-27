package com.example.youquiz.participate;


import java.util.List;

public interface IParticipate {
    List<ParticipateDTOres> findAll();
    ParticipateDTOres findById(ParticipateID id);
    ParticipateDTOres save(ParticipateDTOreq participateDTOreq);
    ParticipateDTOres deleteById(ParticipateID id);
    ParticipateDTOres update(ParticipateDTOreq participateDTOreq);
}
