package ru.zk.echoBot.commands;

import org.telegram.telegrambots.meta.bots.AbsSender;
import ru.zk.echoBot.logic.BotResponse;


public interface BaseCommand
{
    public void execute(AbsSender absSender, BotResponse botResponse);
}
