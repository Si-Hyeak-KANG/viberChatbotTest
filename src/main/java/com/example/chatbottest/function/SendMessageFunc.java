package com.example.chatbottest.function;

import com.example.chatbottest.dto.SendMessage;
import com.example.chatbottest.dto.Sender;
import org.json.JSONObject;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

public class SendMessageFunc{

    public static ResponseEntity<String> send(String callback) {

        String senderId = new JSONObject(callback).getJSONObject("sender").getString("id");
        String senderName = new JSONObject(callback).getJSONObject("sender").getString("name");
        String senderAvatar = new JSONObject(callback).getJSONObject("sender").getString("avatar");
        Sender receiver = new Sender(senderName, senderAvatar);
        String url = "https://chatapi.viber.com/pa/send_message";

        SendMessage body = SendMessage.builder()
                .receiver(senderId)
                .minApiVersion(1)
                .sender(receiver)
                .trackingData("tracking data")
                .type("text")
                .text("멍멍")
                .build();

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.add("X-Viber-Auth-Token", "51375b70e3a7e340-3874f3e396e15f3c-cd7134f6cda50c20");
        HttpEntity<SendMessage> request = new HttpEntity<>(body, headers);

        RestTemplate rt = new RestTemplate();
        return rt.postForEntity(url, request, String.class);

    }
}
