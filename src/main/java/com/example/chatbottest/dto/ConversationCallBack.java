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
public class ConversationCallBack {

    String event;
    long timestamp;

    @JsonProperty("message_token")
    long messageToken;

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
