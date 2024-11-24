package ticketingsystem.receipts;

public class SMSReceipt implements ReceiptInterface {
    private String phoneNumber;
    private static final double FEE = 0.1;
    private ReceiptInterface receipt;

    public SMSReceipt(String phoneNumber, ReceiptInterface receipt) {
        this.phoneNumber = phoneNumber;
        this.receipt = receipt;
    }

    public String send() {
        String msg = receipt.send() + "Sending an sms to " + phoneNumber + "\n";
        return msg;
    }

    public double getCost() {
        return receipt.getCost() + FEE;
    }

}
