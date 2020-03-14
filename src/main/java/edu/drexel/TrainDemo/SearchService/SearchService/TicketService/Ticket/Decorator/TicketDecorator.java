// package
// imports

public abstract class TicketDecorator extends Ticket
{

    private Ticket ticket;

    public String decorate()
    {
        return ticket.decorate();
    }

} // End of TicketDecorator
