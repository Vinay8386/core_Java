package Java17.Payment_Processing.WithoutRecordClass;

import java.io.Serializable;

// =====================================================
// Sealed Class
// =====================================================
public sealed class Payment implements Serializable permits CreditCardPayment, UpiPayment {
    private static final long serialVersionUID = 1L;
    
}
