package services;
import constants.Notifier;
import services.MessageSender;
import services.EmailSender;
import services.SmsSender;

import constants.PaymentMethods;

public class ReservationService {
    private PaymentProcessor paymentProcessor = new PaymentProcessor();
    private MessageSender messageSender;

    public void makeReservation(Reservation res, PaymentMethods paymentType, Notifier notifier) {
        System.out.println("Processing reservation for " + res.customer.name);

        applyCityDiscount(res);       
        handlePayment(paymentType, res.totalPrice()); 
        printInvoice(res);            
        notifyCustomer(notifier, res.customer.email); 
    }

    
    private void applyCityDiscount(Reservation res) {
        if (res.customer.city.equals("Paris")) {
            System.out.println("Apply city discount for Paris!");
            res.room.price *= 0.9;
        }
    }

    private void handlePayment(PaymentMethods paymentType, double totalPrice) {
        switch (paymentType) {
            case CARD -> paymentProcessor.payByCard(totalPrice);
            case PAYPAL -> paymentProcessor.payByPayPal(totalPrice);
            case CASH -> paymentProcessor.payByCash(totalPrice);
            default -> System.out.println("Unsupported payment method!");
        }
    }

    private void printInvoice(Reservation res) {
        System.out.println("----- INVOICE -----");
        System.out.println("customer: " + res.customer.name);
        System.out.println("room: " + res.room.number + " (" + res.room.type + ")");
        System.out.println("Total: " + res.totalPrice());
        System.out.println("-------------------");
    }

    private MessageSender messageSender;

public void notifyCustomer(Notifier notifier, String to) {
    switch (notifier) {
        case EMAIL:
            messageSender = new EmailSender();
            break;
        case SMS:
            messageSender = new SmsSender();
            break;
        default:
            System.out.println("Notifier type not supported yet.");
            return;
    }
    messageSender.send(to, "Your reservation has been confirmed.");
}

}
