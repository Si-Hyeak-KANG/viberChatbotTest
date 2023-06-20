package com.example.chatbottest;

public class WelcomeMessage extends CallBackMessage {

    String thumbnail;

    public WelcomeMessage(Sender sender, String tracking_data, String type, String text, String media, String thumbnail) {
        super(sender, tracking_data, type, text, media);
        this.thumbnail = thumbnail;
    }
}
