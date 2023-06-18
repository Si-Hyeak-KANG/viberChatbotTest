package com.example.chatbottest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ViberBotController {

    @GetMapping(value = "/")
    public String helloWorld() {return "변경 되었습닏!";}

    @GetMapping(value = "/api/health")
    public String healthCheck() {return "Health check completed.";}

    @PostMapping(value = "/api/bot/test")
    public String webhookTest() {
        return "hello bot";
    }

}
