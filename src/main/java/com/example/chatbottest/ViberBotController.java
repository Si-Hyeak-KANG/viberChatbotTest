package com.example.chatbottest;

import org.json.JSONObject;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ViberBotController {

    static String currEvent;
    @GetMapping(value = "/")
    public String helloWorld() {
        return currEvent;
    }

    @GetMapping(value = "/api/health")
    public String healthCheck() {
        return "Health check completed.";
    }

    @CustomPostMapping
    @PostMapping(value = "/api/bot/test")
    public ResponseEntity<WelcomeMessage> webhookTest(@RequestBody String json) {
        String event = new JSONObject(json).getString("event");
        currEvent = event;
        return switch (event) {
            case "conversation_started" -> sendWelcomeMessage(json);
            case "message" -> userRequest(json);
            default -> throw new IllegalStateException("Unexpected value: " + event);
        };
    }

    private ResponseEntity<WelcomeMessage> userRequest(String json) {
        String userInputVariable = new JSONObject(json).getJSONObject("message").getString("text");
        return ResponseEntity.ok(new WelcomeMessage(
                new Sender("test", "https://avatars.githubusercontent.com/u/79829085?v=4"),
                "tracking_data", "picture", userInputVariable, "media", "https://avatars.githubusercontent.com/u/79829085?v=4"));
    }

    public ResponseEntity<WelcomeMessage> sendWelcomeMessage(String json) {
        return ResponseEntity.ok(new WelcomeMessage(
                new Sender("test", "https://avatars.githubusercontent.com/u/79829085?v=4"),
                "tracking_data", "picture", "Welcome", "media", "https://avatars.githubusercontent.com/u/79829085?v=4"));

    }

}
