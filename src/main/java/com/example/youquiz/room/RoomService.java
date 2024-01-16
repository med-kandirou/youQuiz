package com.example.youquiz.room;

import com.example.youquiz.Exception.ResourceNotFoundException;

import com.example.youquiz.participate.ParticipateDTOreq;
import com.example.youquiz.participate.ParticipateID;
import com.example.youquiz.participate.ParticipateService;
import com.example.youquiz.student.Student;
import com.example.youquiz.student.StudentRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;


@Service
public class RoomService implements ISalle {
    private final RoomRepository roomRepository;
    private final StudentRepository studentRepository;
    private final ParticipateService participateService;
    private final ModelMapper modelMapper;

    private RoomService(ParticipateService participateService,StudentRepository studentRepository, RoomRepository roomRepository, ModelMapper modelMapper){
        this.studentRepository=studentRepository;
        this.roomRepository = roomRepository;
        this.modelMapper=modelMapper;
        this.participateService=participateService;
    }

    @Override
    public List<RoomDTOres> findAll() {
        List<Room> salles = roomRepository.findAll();
        return salles.stream()
                .map(r -> modelMapper.map(r, RoomDTOres.class))
                .collect(Collectors.toList());
    }

    public RoomDTOres findById(int id) {
        Room room = roomRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("id : " + id));
        return modelMapper.map(room, RoomDTOres.class);
    }

    @Override
    public RoomDTOres save(RoomDTOreq roomDTOreq) {
        Room room= modelMapper.map(roomDTOreq, Room.class);
        Student student = studentRepository.findById(roomDTOreq.getStudent_id())
                .orElseThrow(() -> new ResourceNotFoundException("id student: " + roomDTOreq.getStudent_id()));
        room.setCreator(student);
        roomRepository.save(room);
        ParticipateDTOreq part= new ParticipateDTOreq();

        // Set ParticipateID
        ParticipateID participateID = new ParticipateID();
        participateID.setRoom(room);
        participateID.setStudent(student);
        part.setParticipateID(participateID);
        part.setDateParticipation(LocalDate.now());
        participateService.save(part);
        return modelMapper.map(room, RoomDTOres.class);
    }


    public RoomDTOres deleteById(int id){
        Room room = roomRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("id : " + id));
        roomRepository.deleteById(id);
        return modelMapper.map(room, RoomDTOres.class);
    }

    @Override
    public RoomDTOres update(RoomDTOreq roomDTOreq) {
        return null;
    }
}
