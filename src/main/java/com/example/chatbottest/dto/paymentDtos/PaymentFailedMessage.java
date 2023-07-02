package com.example.chatbottest.dto.paymentDtos;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

/**
 * TYPE: TextMessage
 */
@AllArgsConstructor
@NoArgsConstructor
public class PaymentFailedMessage {

    private String receiver;

    @JsonProperty("min_api_version")
    private int minApiVersion;

    private Sender sender;

    @JsonProperty("tracking_data")
    private String trackingData;

    private String type;

    private String text;

    public static PaymentFailedMessage of(String id) {
        return new PaymentFailedMessage(
                id,
                1,
                new Sender("james", "https://ifh.cc/g/ybxotT.jpg"),
                "tracking_data",
                "text",
                "결제에 실패했습니다.");
    }
}
