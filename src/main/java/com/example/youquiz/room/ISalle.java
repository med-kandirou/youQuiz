package com.example.youquiz.room;


import java.util.List;

public interface ISalle {
    List<RoomDTOres> findAll();
    RoomDTOres findById(int id);
    RoomDTOres save(RoomDTOreq RoomDTOreq);
    RoomDTOres deleteById(int id);
    RoomDTOres update(RoomDTOreq RoomDTOreq);
}
