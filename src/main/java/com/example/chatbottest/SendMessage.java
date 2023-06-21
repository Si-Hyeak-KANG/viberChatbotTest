package com.example.chatbottest;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class SendMessage {

    String receiver;
    int minApiVersion;
    Sender sender;

    @JsonProperty("tracking_data")
    String trackingData;

    String type;
    String text;
}
