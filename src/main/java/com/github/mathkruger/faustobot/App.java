package com.github.mathkruger.faustobot;

import com.pengrad.telegrambot.TelegramBot;
import com.pengrad.telegrambot.UpdatesListener;
import com.pengrad.telegrambot.model.Update;
import com.pengrad.telegrambot.request.SendMessage;

/**
 * Hello world!
 *
 */
public class App {
    public static void main(final String[] args) {
        // Create your bot passing the token received from @BotFather
        final TelegramBot bot = new TelegramBot("960086829:AAGPUDcynj803cXe5gTgRYkawyUI76depds");

        // Register for updates
        bot.setUpdatesListener(updates -> {
            for (Update update : updates) {
                final long chatId = update.message().chat().id();
                bot.execute(new SendMessage(chatId, "Eae, " + update.message().from().firstName() + "! OLOCO MEU!"));
            }

            return UpdatesListener.CONFIRMED_UPDATES_ALL;
        });
        
    }
}
