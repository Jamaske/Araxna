package ru.zk.araxnaBot;

import org.telegram.telegrambots.meta.api.objects.Update;
import ru.zk.araxnaBot.logic.BotRequest;

public interface MessageConverter {
    BotRequest convertMessage(Update update);
}

