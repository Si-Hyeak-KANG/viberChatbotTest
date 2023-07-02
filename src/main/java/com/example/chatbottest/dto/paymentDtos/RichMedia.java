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
    private List<?> buttons;


    public static RichMedia of(String type, int buttonsGroupColumns, int buttonsGroupRows, String bgColor) {
        return new RichMedia(type, buttonsGroupColumns, buttonsGroupRows, bgColor, List.of(
                ButtonsForImage.of(6, 7, "none", "https://www.google.com", "https://picsum.photos/id/237/200/300")
//                ButtonsForText.of(6, 1, "none", "상품제목", "<font color=#323232><b>" + "Cheeseburger Solo" + "</b></font>", "large", "middle", "left"),
//                ButtonsForText.of(6, 1, "none", "브랜드명", "<font color=#323232>" + "Mcdonald's" + "</font>", "small", "middle", "left"),
//                ButtonsForText.of(6, 2, "none", "발신자명,메시지", "<font color=#323232> FROM." + "강시혁" + "</font><br><br>" + "<font color=#323232> message: &quot;" + "생일 축하한다~!" + "&quot; </font>", "medium", "middle", "left"),
//                ButtonsForText.of(6, 2, "none", "코드,만료날짜", "<font color=#323232><b>Code : " + "dsfksjdfkjsdfhisdholvaksdfdsfadfvfdva" + "</b></font><br><font color=#323232><b>Expire Date : " + "02/07/23" + "</b></font>", "small", "middle", "left"),
//                ButtonsForText.of(6, 3, "none", "수신자명,성공", "<font color=#323232><b>" + "제임스" + " 님의 이메일로 선물을 성공적으로 전송했습니다.</b></font>", "medium", "middle", "left"),
//                ButtonsForText.of(6, 2, "none", "포인트내역", "<font color=#FF0115>사용 포인트 : " + "500p" + "</font><br><font color=#323232>남은 포인트 : " + "9500p" + "</font>", "medium", "middle", "left"),
//                ButtonsForButton.of(6, 1, "open-url", "https://www.google.com", "#6863F2", "<font color=#FFFFFF>see participating stores</font>", "small", "middle", "middle"),
//                ButtonsForButton.of(6, 1, "open-url", "https://www.google.com", "#6863F2", "<font color=#FFFFFF>terms of use</font>", "small", "middle", "middle")
        ));
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
