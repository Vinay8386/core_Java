package Java17.Payment_Processing.WithRecordClass;

import java.io.Serializable;

// =====================================================
// Sealed Interface
// =====================================================
public sealed interface Payment extends Serializable permits CreditCardPayment, UpiPayment {
    
}

// =====================================================
// Record #1
// =====================================================
record CreditCardPayment(String cardNumber, double amount) implements Payment{

}

// =====================================================
// Record #2
// =====================================================
record UpiPayment(String UpiId, double amount) implements Payment{

}
