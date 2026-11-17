package Java17.Payment_Processing.WithRecordClass;

import java.io.Serializable;

// =====================================================
// Sealed Interface
// =====================================================
public sealed interface Payment extends Serializable permits CreditCardPayment, UpiPayment {
    
}
