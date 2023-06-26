package com.example.chatbottest;

import com.example.chatbottest.function.ConversationStartedFunc;
import com.example.chatbottest.function.SendMessageFunc;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.json.JSONObject;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@Slf4j
@RestController
@RequiredArgsConstructor
public class ViberBotController {

    @GetMapping(value = "/")
    public String helloWorld() {
        return "hello";
    }

    @GetMapping(value = "/api/health")
    public String healthCheck() {
        return "Health check completed.";
    }

    @PostMapping("/viber/bot/webhook")
    public ResponseEntity<?> webhookTest(@RequestBody String callback) throws IOException {
        String event = new JSONObject(callback).getString("event");
        return switch (event) {
            case "conversation_started" -> ConversationStartedFunc.sendWelcomeMessage();
            case "message" -> SendMessageFunc.send(callback);
            default -> throw new IllegalStateException("Unexpected value: " + event);
        };
    }
}
