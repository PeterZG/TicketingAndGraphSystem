package ticketingsystem.receipts;

public class PostReceipt implements ReceiptInterface {
    private String address;
    private static final double FEE = 0.5;
    private ReceiptInterface receipt;

    public PostReceipt(String address, ReceiptInterface receipt) {
        this.address = address;
        this.receipt = receipt;
    }

    public String send() {
        String msg = receipt.send() + "Sending your mail to " + address + "\n";
        return msg;
    }

    public double getCost() {
        return receipt.getCost() + FEE;
    }

}
