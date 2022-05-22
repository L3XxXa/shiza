import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;


public class TelegramBot extends TelegramLongPollingBot {
    private String chatId;
    private String state;

    @Override
    public String getBotUsername() {
        return System.getenv("BOTNAME");
    }

    @Override
    public String getBotToken() {
        return System.getenv("TOKEN");
    }

    @Override
    public void onUpdateReceived(Update update) {
        SendMessage sendMessage = new SendMessage();
        Calculator calculator = new Calculator();
        chatId = update.getMessage().getChatId().toString();
        sendMessage.setChatId(chatId);
        String msg = recMsg(update.getMessage().getText(), update);
        if (state.equals("Menu")){
            sendMessage.setText(msg);
        }
        if (state.equals("Calculator")){
            sendMessage.setText(calculator.calculate(msg));
        }
        try {
             execute(sendMessage);
        } catch (TelegramApiException telegramApiException) {
               telegramApiException.printStackTrace();
        }
    }

    public String recMsg(String msg, Update update){
        state = "Menu";
        if (msg.equals("/start")){
            return "I am a calculator bot. Task 1.4.1. Write 'Help', to show help message.";
        }
        if (msg.equals("/help")){

            return "I  am prefix calculator. If you want to get list of all operations, use '/operations'.";
        }
        if (msg.equals("/operations")){
            return "Operations:\nAddition\nSubtraction\nMultiplication\nDivision\nCosines\nSinus\nLn\nLogarithm with base\nPow\nSquare quadratic root";
        }
        if (msg.equals("Change language")){
            return "Out of order";
        }
        if(msg.equals("/calculate")){
            return "Now in calculator state";
        }
        state = "Calculator";
        return msg;


    }

}






