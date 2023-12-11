package ru.zk.araxnaBot.logic;

public class BotRequest {
    public final long userId;
    private final long chatId;
    private final int messageId;
    private final String message;

    public BotRequest(long userId, long chatId, int messageId, String message) {
        this.userId = userId;
        this.chatId = chatId;
        this.messageId = messageId;
        this.message = message;
    }

    public long getUserId() {
        return userId;
    }

    public long getChatId() {
        return chatId;
    }

    public int getMessageId() {
        return messageId;
    }
    public String getMessage() {
        return message;
    }
}