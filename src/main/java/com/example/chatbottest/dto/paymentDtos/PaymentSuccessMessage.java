package com.example.chatbottest.dto.paymentDtos;

import com.example.chatbottest.dto.WelcomeButton;
import com.example.chatbottest.dto.WelcomeKeyboard;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import java.util.Collections;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class PaymentSuccessMessage {

    private String receiver;

    private String type;

    @JsonProperty("min_api_version")
    private int minApiVersion;

    private WelcomeKeyboard keyboard;

    @JsonProperty("rich_media")
    private RichMedia richMedia;


    public static PaymentSuccessMessage of(String id) {
        return new PaymentSuccessMessage(
                id,
                "rich_media",
                7,
                WelcomeKeyboard.of("keyboard", false,"#FFFFFF", createButtons()),
                RichMedia.of("rich_media", 6, 7, "#F2F2F2"));
    }

    public static List<WelcomeButton> createButtons() {
        return Collections.singletonList(WelcomeButton.of());
    }
}
