package ru.zk.araxnaBot.commands;

import org.telegram.telegrambots.meta.bots.AbsSender;
import ru.zk.araxnaBot.logic.BotResponse;


public interface BaseCommand
{
    public void execute(AbsSender absSender, BotResponse botResponse);
}
