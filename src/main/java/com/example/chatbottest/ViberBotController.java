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

@RestController
public class ViberBotController {

    static String currEvent;
    static String currUserInputText;

    @GetMapping(value = "/")
    public String helloWorld() {
        return "event: " + currEvent + ", inputText: " + currUserInputText ;
    }

    @GetMapping(value = "/api/health")
    public String healthCheck() {
        return "Health check completed.";
    }

    @PostMapping(value = "/api/bot/test")
    public ResponseEntity<? extends CallBackMessage> webhookTest(@RequestBody String json) throws IOException {

        return ResponseEntity.ok(
                new WelcomeMessage(
                        new Sender("test", "https://avatars.githubusercontent.com/u/79829085?v=4"),
                        "tracking data",
                        "picture",
                        "Welcome",
                        "https://avatars.githubusercontent.com/u/79829085?v=4",
                        "https://avatars.githubusercontent.com/u/79829085?v=4")
        );
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
