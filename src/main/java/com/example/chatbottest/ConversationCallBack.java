package com.example.chatbottest;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ConversationCallBack {

    String event;
    LocalDateTime timestamp;

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
