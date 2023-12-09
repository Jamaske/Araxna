package ru.zk.echoBot;

import org.telegram.telegrambots.meta.api.objects.Update;
import ru.zk.echoBot.logic.BotRequest;

public interface MessageConverter {
    BotRequest convertMessage(Update update);
}

