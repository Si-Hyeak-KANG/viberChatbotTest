package com.example.chatbottest;

import lombok.Data;

@Data
public class User {

    String id;
    String name;
    String avatar;
    String country;
    String language;
    int api_version;
}
