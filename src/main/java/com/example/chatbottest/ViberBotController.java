package com.example.chatbottest;

import com.example.chatbottest.dto.SendMessage;
import com.example.chatbottest.dto.Sender;
import com.example.chatbottest.dto.WelcomeMessage;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.json.JSONObject;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;
import java.util.Objects;

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
    public ResponseEntity<WelcomeMessage> webhookTest(@RequestBody String callback) throws IOException {

        String event = new JSONObject(callback).getString("event");
        String trackingData = new JSONObject(callback).getString("tracking_data");

        log.info("event = {}, tracking_data = {}", event, trackingData);

//        if (Objects.equals(event, "message")) {
//            log.info("메시지 전송 시작");
//            String senderId = new JSONObject(callback).getJSONObject("sender").getString("id");
//            String senderName = new JSONObject(callback).getJSONObject("sender").getString("name");
//            String senderAvatar = new JSONObject(callback).getJSONObject("sender").getString("avatar");
//
//            log.info("id = {}, name = {}, avatar = {}", senderId, senderName, senderAvatar);
//
//            Sender receiver = new Sender(senderName, senderAvatar);
//            String url = "https://chatapi.viber.com/pa/send_message";
//
//            SendMessage body = SendMessage.builder()
//                    .receiver(senderId)
//                    .minApiVersion(1)
//                    .sender(receiver)
//                    .trackingData(trackingData)
//                    .type("text")
//                    .text("멍멍")
//                    .build();
//
//            HttpHeaders headers = new HttpHeaders();
//            headers.setContentType(MediaType.APPLICATION_JSON);
//            headers.add("X-Viber-Auth-Token","51375b70e3a7e340-3874f3e396e15f3c-cd7134f6cda50c20");
//            HttpEntity<SendMessage> request = new HttpEntity<>(body, headers);
//
//            RestTemplate rt = new RestTemplate();
//            ResponseEntity<String> response = rt.postForEntity(url, request, String.class);
//
//            if (response.getStatusCode() == HttpStatus.OK) {
//                System.out.println("Message sent successfully.");
//            } else {
//                System.out.println("Failed to send message.");
//            }
//        }

        // 이미지 URL 중요함.....
        return ResponseEntity.ok(WelcomeMessage.builder()
                .sender(new Sender("John McClane", "https://picsum.photos/id/237/200/300"))
                .trackingData("tracking data")
                .type("picture")
                .text("hi")
                .media("https://picsum.photos/id/237/200/300")
                .thumbnail("https://picsum.photos/id/237/200/300").build());
    }
}
