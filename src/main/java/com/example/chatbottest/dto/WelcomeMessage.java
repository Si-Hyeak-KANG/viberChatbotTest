package com.example.chatbottest.dto;

import com.example.chatbottest.dto.Sender;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class WelcomeMessage {

    Sender sender;

    @JsonProperty("tracking_data")
    String trackingData;

    String type;
    String text;
    String media;
    String thumbnail;
}
