package com.example.chatbottest;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.reactive.function.client.WebClient;

import java.io.IOException;

@RestController
@RequiredArgsConstructor
public class ViberBotController {

    private final WebClient webClient;

    @GetMapping(value = "/")
    public String helloWorld() {
        return "hello";
    }

    @GetMapping(value = "/api/health")
    public String healthCheck() {
        return "Health check completed.";
    }

    @PostMapping("/viber/bot/webhook")
    public ResponseEntity<WelcomeMessage> webhookTest(@RequestBody String request) throws IOException {

        // 이미지 URL 중요함.....
        return ResponseEntity.ok(WelcomeMessage.builder()
                .sender(new Sender("John McClane", "https://picsum.photos/id/237/200/300"))
                .trackingData("tracking data")
                .type("picture")
                .text("hi")
                .media("https://picsum.photos/id/237/200/300")
                .thumbnail("https://picsum.photos/id/237/200/300").build());
    }

    /**
     * data.put("receiver", "YZmWEo/KBmn/6PKQW0qBxg==");
     * data.put("min_api_version", 1);
     * data.put("sender", new Sender("test", "https://picsum.photos/id/237/200/300"));
     * data.put("tracking_data", "tracking data");
     * data.put("type","text");
     * data.put("text", text);
     */


}
