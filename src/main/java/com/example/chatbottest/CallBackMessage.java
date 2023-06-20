package com.example.chatbottest;

public class CallBackMessage {
    Sender sender;
    String tracking_data;
    String type;
    String text;
    String media;

    public CallBackMessage(Sender sender, String tracking_data, String type, String text, String media) {
        this.sender = sender;
        this.tracking_data = tracking_data;
        this.type = type;
        this.text = text;
        this.media = media;
    }

    public CallBackMessage() {
    }
}
