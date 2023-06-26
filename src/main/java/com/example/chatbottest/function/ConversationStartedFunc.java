package com.example.chatbottest.function;

import com.example.chatbottest.dto.Sender;
import com.example.chatbottest.dto.WelcomeMessage;
import org.springframework.http.ResponseEntity;

public class ConversationStartedFunc {

    public static ResponseEntity<WelcomeMessage> sendWelcomeMessage() {
        return ResponseEntity.ok(WelcomeMessage.builder()
                .sender(new Sender("John McClane", "https://picsum.photos/id/237/200/300"))
                .trackingData("tracking data")
                .type("picture")
                .text("hi")
                .media("https://picsum.photos/id/237/200/300")
                .thumbnail("https://picsum.photos/id/237/200/300").build());
    }
}
