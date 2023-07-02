package com.example.chatbottest.dto.paymentDtos;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

    private static Map<String, Object> getImage() {
        HashMap<String, Object> map = new HashMap<>();
        map.put("Columns", 6);
        map.put("Rows", 7);
        map.put("ActionType", "none");
        map.put("ActionBody", "https://www.google.com");
        map.put("Image", "https://picsum.photos/id/237/200/300");
        return map;
    }


}
