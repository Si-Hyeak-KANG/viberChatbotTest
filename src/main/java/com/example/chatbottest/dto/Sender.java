package com.example.chatbottest.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Sender {

    String name;
    String avatar;

    @Override
    public String toString() {
        return "name='" + name + '\'' +
                ", avatar='" + avatar + '\'';
    }
}
