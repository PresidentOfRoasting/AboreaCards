package com.example.demo;

import com.example.demo.model.Adventure;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.stereotype.Controller;
import org.springframework.messaging.simp.SimpMessagingTemplate;

@Controller
public class WebSocketHandler {
    private final SimpMessagingTemplate messagingTemplate;

    public WebSocketHandler(SimpMessagingTemplate messagingTemplate) {
        this.messagingTemplate = messagingTemplate;
    }

    @MessageMapping("/your-message-endpoint")
    public void handleWebSocketMessage(String message) throws JsonProcessingException {
        // Handle the message and prepare the Adventure object
        Adventure adventure = new Adventure();

        // Serialize the Adventure object to JSON
        String adventureJson = AdventureToJsonConverter.convertAdventureToJson(adventure);

        // Send it to the user (Angular app)
        messagingTemplate.convertAndSendToUser("user", "/topic/your-response-topic", adventureJson);
    }
}
