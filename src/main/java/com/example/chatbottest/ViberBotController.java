package com.example.chatbottest;

import org.json.JSONObject;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashMap;

@RestController
public class ViberBotController {

    static String event = "";
    static boolean isMessage = false;

    @GetMapping(value = "/")
    public String helloWorld() {
        String result = event;
        if (isMessage) {
           result += " send Message";
        }
        return result;
    }

    @GetMapping(value = "/api/health")
    public String healthCheck() {
        return "Health check completed.";
    }

    @PostMapping("/viber/bot/webhook")
    public ResponseEntity<WelcomeMessage> webhookTest(@RequestBody HashMap<String, Object> request) throws IOException {

        event = request.get("event").toString();
        if (event.equals("message")) sendMessageToUser("메시지 받으셨나요?", "https://chatapi.viber.com/pa/send_message");

        // 이미지 URL 중요함.....
        return ResponseEntity.ok(WelcomeMessage.builder()
                .sender(new Sender("John McClane","https://picsum.photos/id/237/200/300"))
                .trackingData("tracking data")
                .type("picture")
                .text("hi")
                .media("https://picsum.photos/id/237/200/300")
                .thumbnail("https://picsum.photos/id/237/200/300").build());
    }

//
//    private ResponseEntity<SuccessMessage> userRequest(String json) throws IOException {
//        String text = new JSONObject(json).getJSONObject("message").getString("text");
//        currUserInputText = text;
//        String url = "https://chatapi.viber.com/pa/send_message";
//        sendMessageToUser(text, url);
//        return ResponseEntity.ok(new SuccessMessage());
//    }
//
//
    private static void sendMessageToUser(String text, String url) throws IOException {
        HttpURLConnection con = (HttpURLConnection) new URL(url).openConnection();
        con.setRequestMethod("POST");
        con.setRequestProperty("Content-Type", "application/json");
        con.setRequestProperty("X-Viber-Auth-Token", "51325d70dda7dc2c-2f10319fe1a387be-b00bd73e2ba977c2");
        JSONObject data = new JSONObject();
        data.put("receiver", "YZmWEo/KBmn/6PKQW0qBxg==");
        data.put("min_api_version", 1);
        data.put("sender", new Sender("test", "https://picsum.photos/id/237/200/300"));
        data.put("tracking_data", "tracking data");
        data.put("type","text");
        data.put("text", text);
        con.setDoOutput(true);
        con.getOutputStream().write(data.toString().getBytes());

        isMessage = true;
    }
}
