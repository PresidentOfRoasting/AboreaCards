package com.example.demo;

import org.springframework.stereotype.Controller;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;


@Controller
public class CustomWebSocketHandler extends TextWebSocketHandler {

    private final SimpMessagingTemplate messagingTemplate;

    public CustomWebSocketHandler(SimpMessagingTemplate messagingTemplate) {
        this.messagingTemplate = messagingTemplate;
    }

    @Override
    protected void handleTextMessage(WebSocketSession session, TextMessage message) throws Exception {
        // Handle the WebSocket message received from the client here
        String payload = message.getPayload();

        // Process and respond to the message as needed

        // Send a response back to the client (if necessary)
        //messagingTemplate.convertAndSendToUser(session.getPrincipal().getName(), "/topic/your-response-topic", responsePayload);
    }
}
