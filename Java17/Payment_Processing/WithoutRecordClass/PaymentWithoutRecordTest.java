package Java17.Payment_Processing.WithoutRecordClass;

import java.io.Serializable;

public class PaymentWithoutRecordTest{

    public static void main(String[] args) {
        
        Payment payment1 = new CreditCardPayment("1234", 360);

        Payment payment2 = new UpiPayment("vk@ybl", 5000);

        System.out.println(payment1 instanceof Serializable);

        System.out.println(payment2 instanceof Serializable);
    }
}