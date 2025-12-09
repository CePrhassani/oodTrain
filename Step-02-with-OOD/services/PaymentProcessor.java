package services;

import constants.PaymentMethods;

public class PaymentProcessor {

    public void process(PaymentMethods method, double amount) {
        switch (method) {
            case CARD -> payByCard(amount);
            case PAYPAL -> payByPayPal(amount);
            case CASH -> payByCash(amount);
            default -> System.out.println("Unsupported payment method!");
        }
    }

    public void payByCard(double amount) {
        System.out.println("Paid " + amount + " by Credit Card");
    }

    public void payByPayPal(double amount) {
        System.out.println("Paid " + amount + " via PayPal");
    }

    public void payByCash(double amount) {
        System.out.println("Paying " + amount + " in cash at the hotel");
    }
}
