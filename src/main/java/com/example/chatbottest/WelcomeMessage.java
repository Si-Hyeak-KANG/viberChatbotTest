package com.example.chatbottest;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class WelcomeMessage {

    Sender sender;
    String trackingData;
    String type;
    String text;
    String media;
    String thumbnail;
}
