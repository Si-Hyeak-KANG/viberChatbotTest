package com.example.chatbottest;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class WelcomeMessage {

    @JsonProperty("sender")
    Sender sender;

    @JsonProperty("tracking_data")
    String trackingData;

    String type;
    String text;
    String media;
    String thumbnail;
}
