package services;

import models.Customer;
import models.Room;

public class Reservation {
    public Room room;
    public Customer customer;
    public int nights;

    public Reservation(Room r, Customer c, int nights) {
        this.room = r;
        this.customer = c;
        this.nights = nights;
    }
    public double totalPrice(){
        return room.price * nights;
    }
    private PaymentProcessor paymentProcessor;
private MessageSender messageSender;

public void setServices(PaymentProcessor paymentProcessor, MessageSender messageSender) {
    this.paymentProcessor = paymentProcessor;
    this.messageSender = messageSender;
}

public void confirm(String customerEmail) {
    paymentProcessor.payByCard(totalPrice());
    messageSender.send(customerEmail, "Reservation confirmed successfully!");
}
}