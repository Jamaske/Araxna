package ru.zk.araxnaBot.telegram;

import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.objects.Update;
import ru.zk.araxnaBot.AnswerWriter;
import ru.zk.araxnaBot.MessageConverter;
import ru.zk.araxnaBot.MessageHandler;
import ru.zk.araxnaBot.commands.BaseCommand;
import ru.zk.araxnaBot.commands.MonitorCommand;
import ru.zk.araxnaBot.commands.StartCommand;
import ru.zk.araxnaBot.logic.BotRequest;
import ru.zk.araxnaBot.logic.BotResponse;
import ru.zk.araxnaBot.logic.EchoMessageHandler;

import java.util.HashMap;
import java.util.Map;

public class Bot extends TelegramLongPollingBot implements AnswerWriter {
    private final String apiKey;
    private final String botName;
    private final MessageConverter converter = new TelegramMessageConverter();
    private final MessageHandler handler = new EchoMessageHandler();
    private final Map<String, BaseCommand> commands = new HashMap<>();

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
