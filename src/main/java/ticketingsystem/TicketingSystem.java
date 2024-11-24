package ticketingsystem;

import ticketingsystem.receipts.EmailReceipt;
import ticketingsystem.receipts.PostReceipt;
import ticketingsystem.receipts.Receipt;
import ticketingsystem.receipts.ReceiptInterface;
import ticketingsystem.receipts.SMSReceipt;

public class TicketingSystem {
    private int ticketsLeft;
    private static TicketingSystem ticketingSystem;

    private TicketingSystem(int numTickets) {
        this.ticketsLeft = numTickets;
    }

    public static synchronized TicketingSystem getInstance(int numTickets) {
        if (ticketingSystem == null) {
            ticketingSystem = new TicketingSystem(numTickets);
        }
        return ticketingSystem;
    }

    public int getTicketsLeft() {
        return ticketsLeft;
    }

    private void setTicketsLeft(int ticketsLeft) {
        this.ticketsLeft = ticketsLeft;
    }

    public synchronized String buyTicket(String email, String sms, String address) {
        String msg = "";
        if (getTicketsLeft() > 0) {
            setTicketsLeft(getTicketsLeft() - 1);
            msg += "There is now " + getTicketsLeft() + " left!" + "\n";
            ReceiptInterface receipt = new Receipt();
            if (email != null) {
                receipt = new EmailReceipt(email, receipt);
            }
            if (sms != null) {
                receipt = new SMSReceipt(sms, receipt);
            }
            if (address != null) {
                receipt = new PostReceipt(address, receipt);
            }
            Double cost = receipt.getCost();
            msg += receipt.send();
            msg += "The total cost is: " + cost + "\n";
            msg += "------------------------------------------";
        } else {
            msg += "Unfortunately there are no tickets left :(";
        }
        System.out.println(msg);
        return msg;
    }

}
