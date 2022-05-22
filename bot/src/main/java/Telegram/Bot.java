package Telegram;

import org.telegram.telegrambots.api.methods.send.SendMessage;
import org.telegram.telegrambots.api.objects.Update;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.exceptions.TelegramApiException;

public class Bot extends TelegramLongPollingBot{
    @Override
    public void onUpdateReceived(Update update) {
        String msg = update.getMessage().getText();
        sendMsg(update.getMessage().getChatId(), msg);
    }

    private void sendMsg(Long chatId, String msg) {
        SendMessage sendMessage = new SendMessage();
        sendMessage.setChatId(chatId);
        sendMessage.setText(msg);
        try{
            execute(sendMessage);
        } catch (TelegramApiException e) {
            e.printStackTrace();
        }
    }

    @Override
    public String getBotUsername() {
        String NAME = "@JabaManBot";
        return NAME;
    }

    @Override
    public String getBotToken() {
        String TOKEN = "1959629979:AAECyBeux736azrgcWF_mmWAQTw4AbtFgIU";
        return TOKEN;
    }
}
