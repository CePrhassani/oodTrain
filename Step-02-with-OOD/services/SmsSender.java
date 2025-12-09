package services;

public class SmsSender implements MessageSender {
    @Override
    public void send(String to, String message) {
        System.out.println("📱 SMS sent to " + to + ": " + message);
    }
}