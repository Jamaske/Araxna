package ru.zk.echoBot.commands;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.bots.AbsSender;
import ru.zk.echoBot.logic.BotResponse;

public class StartCommand implements BaseCommand
{
    public final static String commandId = "/start";
    @Override
    public void execute(AbsSender absSender, BotResponse botResponse) {
        SendMessage message = new SendMessage();
        message.setChatId(String.valueOf(botResponse.getChatId()));
        message.setText("Список доступных команд:\n" +
                        "/start - показать это приветственное сообщение\n" +
                        "/monitor - вывести список живых/неживых нод, их ip адрес и хостнейм");
        try {
            absSender.execute(message);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}