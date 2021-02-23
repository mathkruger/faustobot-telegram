package com.github.mathkruger.faustobot;

import java.io.IOException;
import java.util.Properties;

import com.pengrad.telegrambot.TelegramBot;
import com.pengrad.telegrambot.UpdatesListener;
import com.pengrad.telegrambot.model.Update;
import com.pengrad.telegrambot.request.SendMessage;

public class App {
    public static void main(final String[] args) throws IOException {
        Properties props = PropertiesLoader.loadProperties("application.properties");
        final TelegramBot bot = new TelegramBot(props.getProperty("telegram.bot.key"));

        bot.setUpdatesListener(updates -> {
            for (Update update : updates) {
                final long chatId = update.message().chat().id();
                bot.execute(new SendMessage(chatId, "Eae, " + update.message().from().firstName() + "! OLOCO MEU!"));
            }

            return UpdatesListener.CONFIRMED_UPDATES_ALL;
        });

    }
}
