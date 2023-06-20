package com.example.chatbottest;

public class SendMessage extends CallBackMessage {

    String receiver;
    int minApiVersion;

    public SendMessage(Sender sender, String tracking_data, String type, String text, String media) {
        super(sender, tracking_data, type, text, media);
        this.receiver = "zEjO1IAIu/GE1o2CDJ3g/Q==";
        minApiVersion = 1;
    }
}
