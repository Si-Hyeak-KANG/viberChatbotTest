package com.example.chatbottest;

import com.fasterxml.jackson.databind.util.JSONPObject;
import org.json.JSONObject;
import org.springframework.web.bind.annotation.*;

@RestController
public class ViberBotController {

    static String userInputVariable;

    @GetMapping(value = "/")
    public String helloWorld() {return userInputVariable;}

    @GetMapping(value = "/api/health")
    public String healthCheck() {return "Health check completed.";}

    @PostMapping(value = "/api/bot/test")
    public String webhookTest(@RequestBody String json) {
        String userInput = new JSONObject(json).getJSONObject("message").getString("text");
        System.out.println(userInput);
        userInputVariable = userInput;
        return "hello bot";
    }

}
