package com.example.chatbottest;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ViberBotController {

    @PostMapping("/webhook")
    public String webhookTest() {
        return "hello world";
    }
}
