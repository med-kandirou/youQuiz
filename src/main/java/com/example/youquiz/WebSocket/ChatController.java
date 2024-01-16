package com.example.youquiz.WebSocket;


import com.example.youquiz.message.MessageDTOreq;
import com.example.youquiz.message.MessageDTOres;
import com.example.youquiz.message.MessageService;
import org.springframework.messaging.handler.annotation.DestinationVariable;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;

@Controller
public class ChatController {

    private final MessageService messageService;

    public ChatController(MessageService messageService) {
        this.messageService = messageService;
    }

    @MessageMapping("/chat.sendMessage/{roomId}")
    @SendTo("/room/{roomId}")
    public MessageDTOres send(MessageDTOreq message, @DestinationVariable int roomId){
        return messageService.save(message);
    }

}
