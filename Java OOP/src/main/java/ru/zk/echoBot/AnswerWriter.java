package ru.zk.echoBot;

import ru.zk.echoBot.logic.BotResponse;

public interface AnswerWriter {
    void writeAnswer(BotResponse response);
}
