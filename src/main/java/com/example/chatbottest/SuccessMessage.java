package com.example.chatbottest;

public class SuccessMessage extends CallBackMessage{
    String ok;

    public SuccessMessage(Sender sender, String tracking_data, String type, String text, String media) {
        super(sender, tracking_data, type, text, media);
    }

    public SuccessMessage() {
        this.ok = "ok";
    }
}
