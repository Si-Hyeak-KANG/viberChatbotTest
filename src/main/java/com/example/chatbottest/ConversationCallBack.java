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

    @Override
    public String toString() {
        return "ConversationCallBack{" +
                "event='" + event + '\'' +
                ", timestamp=" + timestamp +
                ", messageToken=" + messageToken +
                ", type='" + type + '\'' +
                ", context='" + context + '\'' +
                ", user=" + user +
                ", subscribed=" + subscribed +
                '}';
    }
}
