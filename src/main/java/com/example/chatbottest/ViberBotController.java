package com.example.chatbottest;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RestController
public class ViberBotController {

    @GetMapping(value = "/")
    public String helloWorld() {
        return "success connection";
    }

    @GetMapping(value = "/api/health")
    public String healthCheck() {
        return "Health check completed.";
    }

    @PostMapping(value = "/api/bot/test")
    public ResponseEntity<WelcomeMessage> webhookTest(@RequestBody ConversationCallBack dto) throws IOException {

        return ResponseEntity.ok(
                WelcomeMessage.builder()
                        .sender(new Sender("Sihyuk",
                                "https://media-direct.cdn.viber.com/download_photo?dlid=7z9xlizcp91wXTJRDe8cXBFmNR9HUa5iN_d3cBYQCNyBJ6tXcoUsS8JIE9c6_4iWAXSarYIfr71fxjtxS4OMbjZ8J_EhVe91qQG85gV20ahElFkiB5XpPT-obQEezWPc8egpAw&fltp=jpg&imsz=0000"))
                        .trackingData("tracking_data")
                        .type("picture")
                        .text("안녕하세요! 환영해요!")
                        .media("https://avatars.githubusercontent.com/u/136808906?s=400&u=b1ecc9d3c587e738a13aa783e1cdc27c25844e10&v=4")
                        .thumbnail("https://avatars.githubusercontent.com/u/136808906?s=400&u=b1ecc9d3c587e738a13aa783e1cdc27c25844e10&v=4")
                        .build());
    }

//    private ResponseEntity<SuccessMessage> userRequest(String json) throws IOException {
//        String text = new JSONObject(json).getJSONObject("message").getString("text");
//        currUserInputText = text;
//        String url = "https://chatapi.viber.com/pa/send_message";
//        sendMessageToUser(text, url);
//        return ResponseEntity.ok(new SuccessMessage());
//    }
//
//    public ResponseEntity<WelcomeMessage> sendWelcomeMessage(String json) {
//        return ResponseEntity.ok(
//                new WelcomeMessage(
//                        new Sender("test", "https://avatars.githubusercontent.com/u/79829085?v=4"),
//                        "tracking data",
//                        "picture",
//                        "Welcome",
//                        "https://avatars.githubusercontent.com/u/79829085?v=4",
//                        "https://avatars.githubusercontent.com/u/79829085?v=4")
//        );
//    }
//
//    private static void sendMessageToUser(String text, String url) throws IOException {
//        HttpURLConnection con = (HttpURLConnection) new URL(url).openConnection();
//        con.setRequestMethod("POST");
//        con.setRequestProperty("Content-Type", "application/json");
//        con.setRequestProperty("X-Viber-Auth-Token", "51325d70dda7dc2c-2f10319fe1a387be-b00bd73e2ba977c2");
//        JSONObject data = new JSONObject();
//        data.put("receiver", "zEjO1IAIu/GE1o2CDJ3g/Q==");
//        data.put("min_api_version", 1);
//        data.put("sender", new Sender("test", "https://avatars.githubusercontent.com/u/79829085?v=4"));
//        data.put("tracking_data", "tracking data");
//        data.put("type","text");
//        data.put("text", text);
//        con.setDoOutput(true);
//        con.getOutputStream().write(data.toString().getBytes());
//    }

}
