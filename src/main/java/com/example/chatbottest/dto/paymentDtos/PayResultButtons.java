package com.example.chatbottest.dto.paymentDtos;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@Getter
@NoArgsConstructor
public class PayResultButtons {

    /**
     * 1) 상품이미지
     * 2) 제품제목
     * 3) 브랜드명
     * 4) 받는사람
     * 5) 메시지
     * 6) 코드
     * 7) 만료날짜
     * 8) 보내는사람
     * 9) 사용포인트
     * 10) 남은포인트
     * 11) 버튼 (see participating stores)
     * 12) 버튼 (terms of use)
     */
    public static List<PayResultButtons> of() {
        return List.of(ButtonsForImage.of(6, 1, "none", "https://www.google.com", "https://picsum.photos/id/237/200/300"),
                ButtonsForText.of(6, 5, "none", "https://www.google.com", "<font color=#323232><b> Cheeseburger Solo </b></font>", "large", "middle", "left"));
//                com.example.chatbottest.dto.paymentDtos.ButtonsForText.of(6, 1, "none", "브랜드명", "<font color=#323232>" + "Mcdonald's" + "</font>", "small", "middle", "left"),
//                com.example.chatbottest.dto.paymentDtos.ButtonsForText.of(6, 2, "none", "발신자명,메시지", "<font color=#323232> FROM." + "강시혁" + "</font><br><br>" + "<font color=#323232> message: &quot;" + "생일 축하한다~!" + "&quot; </font>", "medium", "middle", "left"),
//                com.example.chatbottest.dto.paymentDtos.ButtonsForText.of(6, 2, "none", "코드,만료날짜", "<font color=#323232><b>Code : " + "dsfksjdfkjsdfhisdholvaksdfdsfadfvfdva" + "</b></font><br><font color=#323232><b>Expire Date : " + "02/07/23" + "</b></font>", "small", "middle", "left"),
//                com.example.chatbottest.dto.paymentDtos.ButtonsForText.of(6, 3, "none", "수신자명,성공", "<font color=#323232><b>" + "제임스" + " 님의 이메일로 선물을 성공적으로 전송했습니다.</b></font>", "medium", "middle", "left"),
//                com.example.chatbottest.dto.paymentDtos.ButtonsForText.of(6, 2, "none", "포인트내역", "<font color=#FF0115>사용 포인트 : " + "500p" + "</font><br><font color=#323232>남은 포인트 : " + "9500p" + "</font>", "medium", "middle", "left"),
//                com.example.chatbottest.dto.paymentDtos.ButtonsForButton.of(6, 1, "open-url", "https://www.google.com", "#6863F2", "<font color=#FFFFFF>see participating stores</font>", "small", "middle", "middle"),
//                com.example.chatbottest.dto.paymentDtos.ButtonsForButton.of(6, 1, "open-url", "https://www.google.com", "#6863F2", "<font color=#FFFFFF>terms of use</font>", "small", "middle", "middle")
    }

    @Getter
    @NoArgsConstructor
    @AllArgsConstructor
    public static class ButtonsForImage extends PayResultButtons {

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


    @Getter
    @NoArgsConstructor
    @AllArgsConstructor
    public static class ButtonsForText extends PayResultButtons {

        @JsonProperty("Columns")
        private int columns;

        @JsonProperty("Rows")
        private int rows;

        @JsonProperty("ActionType")
        private String actionType;

        @JsonProperty("ActionBody")
        private String actionBody;

        @JsonProperty("Text")
        private String text;

        @JsonProperty("TextSize")
        private String textSize;

        @JsonProperty("TextVAlign")
        private String textVAlign;

        @JsonProperty("TextHAlign")
        private String textHAlign;


        public static ButtonsForText of(int columns, int rows, String actionType, String actionBody, String text
                , String textSize, String textVAlign, String textHAlign) {
            return new ButtonsForText(columns, rows, text, actionType, actionBody, textSize, textVAlign, textHAlign);
        }
    }

    @Getter
    @NoArgsConstructor
    @AllArgsConstructor
    public static class ButtonsForButton extends PayResultButtons {
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

        public static ButtonsForButton of(int columns, int rows, String actionType, String actionBody
                , String bgColor, String text, String textSize, String textVAlign, String textHAlign) {
            return new ButtonsForButton(columns, rows, text, actionType, actionBody, bgColor, textSize, textVAlign, textHAlign);
        }
    }
}
