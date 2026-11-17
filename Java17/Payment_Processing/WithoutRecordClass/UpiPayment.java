package Java17.Payment_Processing.WithoutRecordClass;

final class UpiPayment extends Payment{
    private static final long serialVersionUID = 1L;

    private final String UpiID;
    private final double amount;

    public UpiPayment(String UpiID, double amount){
        this.UpiID = UpiID;
        this.amount=amount;
    }
    public String getUpiId() {
        return UpiID;
    }

    public double getAmount() {
        return amount;
    }
}
