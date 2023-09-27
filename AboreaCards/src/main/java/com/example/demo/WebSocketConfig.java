package com.example.demo;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.web.socket.config.annotation.EnableWebSocket;
import org.springframework.web.socket.config.annotation.EnableWebSocketMessageBroker;
import org.springframework.web.socket.config.annotation.WebSocketConfigurer;
import org.springframework.web.socket.config.annotation.WebSocketHandlerRegistry;
import org.springframework.web.socket.server.support.HttpSessionHandshakeInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.socket.WebSocketHandler;
import org.springframework.web.socket.handler.TextWebSocketHandler; // Import the TextWebSocketHandler

@Configuration
@EnableWebSocket
@EnableWebSocketMessageBroker
public class WebSocketConfig implements WebSocketConfigurer {

    @Autowired
    private SimpMessagingTemplate messagingTemplate;

    @Override
    public void registerWebSocketHandlers(WebSocketHandlerRegistry registry) {
        registry.addHandler(webSocketHandler(), "/websocket-endpoint")
                .addInterceptors(new HttpSessionHandshakeInterceptor());
    }

    @Bean
    public WebSocketHandler webSocketHandler() {
        return new CustomWebSocketHandler(messagingTemplate); // Create an instance of your custom WebSocketHandler
    }
}
