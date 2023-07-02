package com.example.chatbottest.dto.paymentDtos;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@JsonPropertyOrder()
public class PaymentSuccessMessage {

    private String receiver;

    private String type;

    @JsonProperty("min_api_version")
    private int minApiVersion;

    @JsonProperty("rich_media")
    private RichMedia richMedia;

    public static PaymentSuccessMessage of(String id) {
        return new PaymentSuccessMessage(
                id,
                "rich_media",
                7,
                RichMedia.of("rich_media", 6, 7, "#F2F2F2"));
    }
}
