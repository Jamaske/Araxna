package ru.zk.echoBot.logic;

import ru.zk.echoBot.AnswerWriter;
import ru.zk.echoBot.MessageHandler;

public class EchoMessageHandler implements MessageHandler {
    public void handle(BotRequest request, AnswerWriter writer) {
        BotResponse response = new BotResponse(request.getUserId(), request.getChatId(), request.getMessageId(), request.getMessage());
        writer.writeAnswer(response);
    }
}
