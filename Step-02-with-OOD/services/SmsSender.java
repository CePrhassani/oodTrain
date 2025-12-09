package services;

class SmsSender implements MessageSender{
    public void sendEmail(String to, String message){
        
    }
    public void sendSMS (String to, String message){
        System.out.println("Sending SMS to " + to + ": " + message);
    }
}
