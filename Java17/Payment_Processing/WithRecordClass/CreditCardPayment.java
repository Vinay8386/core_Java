package Java17.Payment_Processing.WithRecordClass;

record CreditCardPayment(String cardNumber, double amount) implements Payment{

}
