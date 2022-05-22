import org.telegram.telegrambots.api.methods.send.SendMessage;
import org.telegram.telegrambots.api.objects.Update;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.exceptions.TelegramApiException;
import org.telegram.telegrambots.*;

public class Tgbot extends TelegramLongPollingBot {
    private final String TOKEN= "1959629979:AAECyBeux736azrgcWF_mmWAQTw4AbtFgIU";
    private final String NAME = "@JabaManBot";

    @Override
    public String getBotUsername() {
        return NAME;
    }

    @Override
    public String getBotToken() {
        return TOKEN;
    }

    @Override
    public void onUpdateReceived(Update update) {
        long chatid = update.getMessage().getChatId();
        String msg = update.getMessage().getText();
        msgSender(chatid, msg);


    }

    public void msgSender(long chatId, String msg){
        SendMessage sendMessage = new SendMessage();
        sendMessage.setChatId(String.valueOf(chatId));
        sendMessage.setText(msg);
        try {
            execute(sendMessage);
        } catch (TelegramApiException e) {
            e.printStackTrace();
        }

    }
}
