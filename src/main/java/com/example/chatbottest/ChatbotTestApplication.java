package com.example.chatbottest;

import com.google.common.util.concurrent.Futures;
import com.viber.bot.api.ViberBot;
import com.viber.bot.message.TextMessage;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.ApplicationListener;

import javax.inject.Inject;
import java.util.Optional;

@SpringBootApplication
public class ChatbotTestApplication implements ApplicationListener<ApplicationReadyEvent> {

    @Inject
    private ViberBot bot;

    @Value("${application.viber-bot.webhook-url}")
    private String webhookUrl;

    public static void main(String[] args) {
        SpringApplication.run(ChatbotTestApplication.class, args);
    }

    @Override
    public void onApplicationEvent(ApplicationReadyEvent appReadyEvent) {
        try {
            bot.setWebhook(webhookUrl).get();
        } catch (Exception e) {
            e.printStackTrace();
        }

        bot.onMessageReceived((event, message, response) -> response.send(message)); // echos everything back
        bot.onConversationStarted(event -> Futures.immediateFuture(Optional.of( // send 'Hi UserName' when conversation is started
                new TextMessage("Hi " + event.getUser().getName()))));


    }


}
