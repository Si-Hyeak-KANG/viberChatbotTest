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
public class SendMessageResponse {

    String status;

    @JsonProperty("status_message")
    String statusMessage;

    @JsonProperty("message_token")
    long messageToken;

    @JsonProperty("chat_hostname")
    String chatHostname;

    @JsonProperty("billing_status")
    int billingStatus;

}
