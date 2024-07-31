package org.eDrink24.controller.message;

import org.eDrink24.service.message.MessageService;
import org.springframework.web.bind.annotation.*;

@RestController
public class MessageController {

    public MessageService messageService;

    public MessageController(MessageService messageService) {
        this.messageService = messageService;
    }

    @PostMapping("/message")
    public @ResponseBody String sendMessage(String phoneNumber) {
        messageService.sendMessage(phoneNumber);
        return "ok";
    }
}
