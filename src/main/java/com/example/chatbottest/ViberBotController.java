package com.example.chatbottest;

import org.json.JSONObject;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;

@RestController
public class ViberBotController {

    static String event = "";

    @GetMapping(value = "/")
    public String helloWorld() {
        return event;
    }

    @GetMapping(value = "/api/health")
    public String healthCheck() {
        return "Health check completed.";
    }

    @PostMapping("/viber/bot/webhook")
    public ResponseEntity<SendMessageResponse> webhookTest(@RequestBody String dto) throws IOException {

        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.set("X-Viber-Auth-Token","51375b70e3a7e340-3874f3e396e15f3c-cd7134f6cda50c20");

        MultiValueMap<String, Object> body = new LinkedMultiValueMap<>();
        body.add("receiver","YZmWEo/KBmn/6PKQW0qBxg==");
        body.add("min_api_version",1);
        body.add("sender",new Sender("John McClane","http://avatar.example.com"));
        body.add("tracking_data","tracking data");
        body.add("type","text");
        body.add("text","Hello world");

        HttpEntity<MultiValueMap<String, Object>> request = new HttpEntity<>(body, headers);

        return restTemplate.postForEntity("https://chatapi.viber.com/pa/set_webhook", request, SendMessageResponse.class);
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
