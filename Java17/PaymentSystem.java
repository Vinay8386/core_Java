package Java17;

// Sealed Interface
sealed interface Payment
        permits UPI, CreditCard, Cash {

    void pay(double amount);
}

// UPI Payment
final class UPI implements Payment {

    @Override
    public void pay(double amount) {
        System.out.println("Paid ₹" + amount + " using UPI");
    }
}

// Credit Card Payment
final class CreditCard implements Payment {

    @Override
    public void pay(double amount) {
        System.out.println("Paid ₹" + amount + " using Credit Card");
    }
}

// Cash Payment
final class Cash implements Payment {

    @Override
    public void pay(double amount) {
        System.out.println("Paid ₹" + amount + " using Cash");
    }
}

// Main Class
public class PaymentSystem {

    public static void main(String[] args) {

        Payment p1 = new UPI();
        Payment p2 = new CreditCard();
        Payment p3 = new Cash();

        p1.pay(1000);
        p2.pay(2500);
        p3.pay(500);
    }
}
