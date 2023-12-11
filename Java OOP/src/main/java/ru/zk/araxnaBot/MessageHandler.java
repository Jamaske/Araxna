package ru.zk.araxnaBot;

import ru.zk.araxnaBot.logic.BotRequest;

public interface MessageHandler {
    void handle(BotRequest request, AnswerWriter writer);
}
