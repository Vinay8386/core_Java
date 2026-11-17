package Java17.Payment_Processing.WithRecordClass;

record UpiPayment(String UpiId, double amount) implements Payment{

}
