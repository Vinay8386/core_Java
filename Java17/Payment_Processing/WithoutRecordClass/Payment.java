package Java17.Payment_Processing.WithoutRecordClass;

import java.io.Serializable;

// =====================================================
// Sealed Interface
// =====================================================
public sealed class Payment implements Serializable permits CreditCardPayment, UpiPayment {
    
}

// =====================================================
// Record #1
// =====================================================
final class CreditCardPayment extends Payment{

    private final String cardNumber;
    private final double amount;

    public CreditCardPayment(String cardNumber, double amount){
        this.cardNumber = cardNumber;
        this.amount=amount;
    }

}

// =====================================================
// Record #2
// =====================================================
final class UpiPayment extends Payment{

    private final String UpiID;
    private final double amount;

    public UpiPayment(String UpiID, double amount){
        this.UpiID = UpiID;
        this.amount=amount;
    }
}
