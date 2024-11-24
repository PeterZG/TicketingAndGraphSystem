package ticketingsystem.receipts;

public class Receipt implements ReceiptInterface {
    private static final double TICKET_COST = 50;

    public String send() {
        String msg = "Yay you bought a ticket!" + "\n";
        return msg;
    }

    public double getCost() {
        return TICKET_COST;
    }

}