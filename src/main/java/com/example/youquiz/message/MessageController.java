package com.example.youquiz.message;



import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/api/Message")
public class MessageController {
    
    private final MessageService messageService;

    public MessageController(MessageService messageService) {
        this.messageService = messageService;
    }

    @GetMapping
    public ResponseEntity<List<MessageDTOres>> all(){
        return new ResponseEntity<>(messageService.findAll(), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<MessageDTOres> save(@Valid @RequestBody MessageDTOreq messageDTOreq){
        return new ResponseEntity<>(messageService.save(messageDTOreq), HttpStatus.OK);
    }

    @PutMapping
    public ResponseEntity<MessageDTOres> update(@Valid @RequestBody MessageDTOreq messageDTOreq){
        return new ResponseEntity<>(messageService.save(messageDTOreq), HttpStatus.OK);
    }

    @GetMapping(path = {"{messageId}"})
    public ResponseEntity<MessageDTOres> findById(@PathVariable("messageId") Integer messageId){
        return new ResponseEntity<>(messageService.findById(messageId), HttpStatus.OK);
    }

    @DeleteMapping(path = {"{messageId}"})
    public ResponseEntity<MessageDTOres> deleteById(@PathVariable("messageId") Integer messageId){
        return new ResponseEntity<>(messageService.deleteById(messageId), HttpStatus.OK);
    }

    @GetMapping(path = {"byRoom/{salleId}"})
    public ResponseEntity<List<MessageDTOres>> findParticipatesByStudentId(@PathVariable("salleId") Integer salleId){
        return new ResponseEntity<>(messageService.findMessagesByRoomId(salleId), HttpStatus.OK);
    }
}
