package ru.zk.echoBot.telegram;

import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.bots.AbsSender;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import ru.zk.echoBot.AnswerWriter;
import ru.zk.echoBot.MessageConverter;
import ru.zk.echoBot.MessageHandler;
import ru.zk.echoBot.commands.BaseCommand;
import ru.zk.echoBot.commands.MonitorCommand;
import ru.zk.echoBot.commands.StartCommand;
import ru.zk.echoBot.logic.BotRequest;
import ru.zk.echoBot.logic.BotResponse;
import ru.zk.echoBot.logic.EchoMessageHandler;

import java.util.HashMap;
import java.util.Map;

public class Bot extends TelegramLongPollingBot implements AnswerWriter {
    private final String apiKey;
    private final String botName;
    private final MessageConverter converter = new TelegramMessageConverter();
    private final MessageHandler handler = new EchoMessageHandler();
    private final Map<String, BaseCommand> commands = new HashMap<String, BaseCommand>();

    public Bot(String apiKey, String botName) {
        super();
        this.apiKey = apiKey;
        this.botName = botName;
        commands.put(new StartCommand().commandId, new StartCommand());
        commands.put(new MonitorCommand().commandId, new MonitorCommand());
    }

    public void onUpdateReceived(Update update) {
        BotRequest request = converter.convertMessage(update);
        handler.handle(request, this);
    }

    @Override
    public String getBotUsername() {
        return botName;
    }
    @Override
    public String getBotToken() {
        return apiKey;
    }

    @Override
    public void writeAnswer(BotResponse response) {
        String command = response.getMessage();
        BaseCommand commandToExecute = commands.get(command);
        if (commandToExecute != null) {
            commandToExecute.execute(this, response);
        }
        /*String m = response.getMessage();
        if (m.equals("/monitor")) {
            SendMessage sendMessage = SendMessage.builder()
                    .text("monitor work")
                    .chatId(String.valueOf(response.getChatId()))
                    .build();
            try {
                execute(sendMessage);
            } catch (TelegramApiException e) {
                throw new RuntimeException(e);
            }
        }
        if (m.equals("/start")) {
            SendMessage sendMessage = SendMessage.builder()
                    .text("start work")
                    .chatId(String.valueOf(response.getChatId()))
                    .build();
            try {
                execute(sendMessage);

            } catch (TelegramApiException e) {
                throw new RuntimeException(e);
            }
        }
        if (m.equals("/help")) {
            SendMessage sendMessage = SendMessage.builder()
                    .text("Список доступных команд:\n" +
                            "/start - запустить бота;\n" +
                            "/monitor - выводит список живых / неживых нод, их ip адрес и хостнейм.")
                    .chatId(String.valueOf(response.getChatId()))
                    .build();
            try {
                execute(sendMessage);

            } catch (TelegramApiException e) {
                throw new RuntimeException(e);
            }
        }
        */
    }
}
