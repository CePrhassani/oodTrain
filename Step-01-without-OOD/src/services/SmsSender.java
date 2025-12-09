package services;

class SmsSender implements MessageSender {
    public void sendSms(String to, String message) {
        System.out.println("Sending SMS to " + to + ": " + message);
    }

    @Override
    public void sendEmail(String to, String message) {
    }
}