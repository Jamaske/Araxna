package ru.zk.araxnaBot.logic;

import ru.zk.araxnaBot.AnswerWriter;
import ru.zk.araxnaBot.MessageHandler;

public class EchoMessageHandler implements MessageHandler {
    public void handle(BotRequest request, AnswerWriter writer) {
        BotResponse response = new BotResponse(request.getUserId(), request.getChatId(), request.getMessageId(), request.getMessage());
        writer.writeAnswer(response);
    }
}
