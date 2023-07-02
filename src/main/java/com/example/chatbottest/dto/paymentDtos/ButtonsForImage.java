package com.example.chatbottest.dto.paymentDtos;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class ButtonsForImage {

    @JsonProperty("Columns")
    private int columns;

    @JsonProperty("Rows")
    private int rows;

    @JsonProperty("ActionType")
    private String actionType;

    @JsonProperty("ActionBody")
    private String actionBody;

    @JsonProperty("Image")
    private String image;

    public static ButtonsForImage of(int columns, int rows, String actionType, String actionBody, String image) {
        return new ButtonsForImage(columns, rows, actionType, actionBody, image);
    }
}
