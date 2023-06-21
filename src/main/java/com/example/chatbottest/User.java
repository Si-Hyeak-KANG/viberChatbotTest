package com.example.chatbottest;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class User {

    String id;
    String name;
    String avatar;
    String country;
    String language;

    @JsonProperty("api_version")
    int apiVersion;
}
