package Java17.Payment_Processing.WithoutRecordClass;

final class CreditCardPayment extends Payment{
    private static final long serialVersionUID = 1L;

    private final String cardNumber;
    private final double amount;

    public CreditCardPayment(String cardNumber, double amount){
        this.cardNumber = cardNumber;
        this.amount=amount;
    }

    public String getCardNumber() {
        return cardNumber;
    }

    public double getAmount() {
        return amount;
    }
}
