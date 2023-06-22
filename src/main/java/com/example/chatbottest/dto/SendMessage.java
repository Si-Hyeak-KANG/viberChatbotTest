package com.example.chatbottest.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class SendMessage {

    String receiver;

    @JsonProperty("min_api_version")
    int minApiVersion;

    Sender sender;

    @JsonProperty("tracking_data")
    String trackingData;

    String type;
    String text;
}
