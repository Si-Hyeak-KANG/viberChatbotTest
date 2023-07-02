package com.example.chatbottest.dto.paymentDtos;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class RichMedia {

    @JsonProperty("Type")
    private String type;

    @JsonProperty("ButtonsGroupColumns")
    private int buttonsGroupColumns;

    @JsonProperty("ButtonsGroupRows")
    private int buttonsGroupRows;

    @JsonProperty("BgColor")
    private String bgColor;

    @JsonProperty("Buttons")
    private List<PayResultButtons> buttons;


    public static RichMedia of(String type, int buttonsGroupColumns, int buttonsGroupRows, String bgColor) {
        return new RichMedia(type, buttonsGroupColumns, buttonsGroupRows, bgColor, PayResultButtons.of());
    }
}
