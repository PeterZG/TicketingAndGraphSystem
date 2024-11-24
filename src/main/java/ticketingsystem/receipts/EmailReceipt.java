package ticketingsystem.receipts;

public class EmailReceipt implements ReceiptInterface {
    private String email;
    private static final double FEE = 0;
    private ReceiptInterface receipt;

    public EmailReceipt(String email, ReceiptInterface receipt) {
        this.email = email;
        this.receipt = receipt;
    }

    public String send() {
        String msg = receipt.send() + "Sending an email to " + email + "\n";
        return msg;
    }

    public double getCost() {
        return receipt.getCost() + FEE;
    }
}
