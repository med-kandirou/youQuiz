package com.example.youquiz.participate;



import com.example.youquiz.room.Room;
import com.example.youquiz.room.RoomDTOres;
import com.example.youquiz.student.Student;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/api/Participate")
public class ParticipateController {

    private final ParticipateService participateService;

    private ParticipateController(ParticipateService participateService){
        this.participateService=participateService;
    }

    @GetMapping
    public ResponseEntity<List<ParticipateDTOres>> getAll(){
        return new ResponseEntity<>(participateService.findAll(), HttpStatus.OK);
    }

    @GetMapping(path = "{roomId}")
    public ResponseEntity<ParticipateDTOres> findById(@PathVariable Integer roomId, @PathVariable Integer studentId) {
        ParticipateID participateId = new ParticipateID();
        Student std = new Student();
        std.setCode(studentId);
        participateId.setStudent(std);
        Room room = new Room();
        room.setId(roomId);
        participateId.setRoom(room);
        return new ResponseEntity<>(participateService.findById(participateId), HttpStatus.OK);
    }


    @PostMapping
    public ResponseEntity<ParticipateDTOres> save(@Valid @RequestBody ParticipateDTOreq participateDTOreq){
        return new ResponseEntity<>(participateService.save(participateDTOreq), HttpStatus.OK);
    }

    @DeleteMapping(path = "{roomId}")
    public ResponseEntity<ParticipateDTOres> delete(@PathVariable Integer roomId, @PathVariable Integer studentId){
        ParticipateID participateId = new ParticipateID();
        Student std = new Student();
        std.setCode(studentId);
        participateId.setStudent(std);
        Room salle = new Room();
        salle.setId(roomId);
        participateId.setRoom(salle);
        return new ResponseEntity<>(participateService.deleteById(participateId), HttpStatus.OK);
    }


    @GetMapping(path = "byStudent/{studentId}/{status}")
    public ResponseEntity<List<RoomDTOres>> findParticipatesByStudent(@PathVariable Integer studentId, @PathVariable String status) {
        return new ResponseEntity<>(participateService.findParticipatesByStudent(studentId,status), HttpStatus.OK);
    }
}
