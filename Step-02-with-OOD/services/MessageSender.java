package services;

public interface MessageSender {
    public void sendEmail(String to, String message);
    public void sendSMS (String to, String message);
    
}
