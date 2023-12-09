package ru.zk.echoBot.commands;

import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.bots.AbsSender;
import ru.zk.echoBot.logic.BotResponse;

public class MonitorCommand implements BaseCommand
{
    public final static String commandId = "/monitor";
    @Override
    public void execute(AbsSender absSender, BotResponse botResponse) {
        SendMessage message = new SendMessage();
        message.setChatId(String.valueOf(botResponse.getChatId()));
        message.setText("Команда монитор работает");
        try {
            absSender.execute(message);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
