package com.example.chatbottest;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class ConversationCallBack {

    String event;
    int timestamp;

    @JsonProperty("message_token")
    int messageToken;

    String type;
    String context;
    User user;
    boolean subscribed;
}
