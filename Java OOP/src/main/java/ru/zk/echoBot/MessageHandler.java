package ru.zk.echoBot;

import ru.zk.echoBot.logic.BotRequest;

public interface MessageHandler {
    void handle(BotRequest request, AnswerWriter writer);
}
