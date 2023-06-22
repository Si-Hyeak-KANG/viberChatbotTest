package com.example.chatbottest;

import jakarta.annotation.PostConstruct;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.client.WebClient;

import java.io.IOException;
import java.util.HashMap;

@RestController
public class ViberBotController {

    static String event = "";
    private WebClient webClient;

    @PostConstruct
    public void initWebClient() {
        webClient = WebClient.create("https://chatapi.viber.com");
    }

    @GetMapping(value = "/")
    public String helloWorld() {
        return event;
    }

    @GetMapping(value = "/api/health")
    public String healthCheck() {
        return "Health check completed.";
    }

    @PostMapping("/viber/bot/webhook")
    public ResponseEntity<WelcomeMessage> webhookTest(@RequestBody HashMap<String, Object> request) throws IOException {

        event = request.get("event").toString();
        if (event.equals("message")) sendMessageToUser("메시지 받으셨나요?");

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
    private String sendMessageToUser(String text) throws IOException {

        MultiValueMap<String, String> data = new LinkedMultiValueMap<>();
        data.add("receiver", "YZmWEo/KBmn/6PKQW0qBxg==");
        data.add("min_api_version", "1");
        data.add("sender", new Sender("test", "https://picsum.photos/id/237/200/300").toString());
        data.add("tracking_data", "tracking data");
        data.add("type", "text");
        data.add("text", text);

        return webClient.post()
                .uri("/pa/send_message")
                .contentType(MediaType.APPLICATION_FORM_URLENCODED)
                .header("X-Viber-Auth-Token","51375b70e3a7e340-3874f3e396e15f3c-cd7134f6cda50c20")
                .body(BodyInserters.fromFormData(data))
                .retrieve()
                .bodyToMono(String.class)
                .block();
    }

}
