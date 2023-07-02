package com.example.chatbottest.dto.paymentDtos;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class ButtonsForButton {

    @JsonProperty("Columns")
    private int columns;

    @JsonProperty("Rows")
    private int rows;

    @JsonProperty("ActionType")
    private String actionType;

    @JsonProperty("ActionBody")
    private String actionBody;

    @JsonProperty("BgColor")
    private String bgColor;

    @JsonProperty("Text")
    private String text;

    @JsonProperty("TextSize")
    private String textSize;

    @JsonProperty("TextVAlign")
    private String textVAlign;

    @JsonProperty("TextHAlign")
    private String textHAlign;

    public static PayResultButtons.ButtonsForButton of(int columns, int rows, String actionType, String actionBody
            , String bgColor, String text, String textSize, String textVAlign, String textHAlign) {
        return new PayResultButtons.ButtonsForButton(columns, rows, text, actionType, actionBody, bgColor, textSize, textVAlign, textHAlign);
    }
}
