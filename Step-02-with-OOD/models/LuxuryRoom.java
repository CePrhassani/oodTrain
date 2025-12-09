package models;

public class LuxuryRoom extends Room {
    private double luxuryFee = 150;

    @Override
    public double totalPrice(int nights) {
        return super.totalPrice(nights) + luxuryFee;
    }
}
