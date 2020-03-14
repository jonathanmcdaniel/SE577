// package
// imports

public class FirstClassUpgrade extends TicketDecorator
{
    public firstClassUpgrade(Ticket ticket)
    {
        super(ticket);
    }

    public String decorate()
    {
        return super.decorate() + decorateWithBusinessClassUpgrade();
    }

    public String decorateWithFirstClassUpgrade()
    {
        return "First Class";
    }

}  // End of FirstClassUpgrade
