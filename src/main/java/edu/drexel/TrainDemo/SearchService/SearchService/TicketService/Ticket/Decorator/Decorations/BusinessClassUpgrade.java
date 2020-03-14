// package
// imports

public class BusinessClassUpgrade extends TicketDecorator
{
    public businessClassUpgrade(Ticket ticket)
    {
        super(ticket);
    }

    public String decorate()
    {
        return super.decorate() + decorateWithBusinessClassUpgrade();
    }

    public String decorateWithBusinessClassUpgrade()
    {
        return "Business Class";
    }

}  // End of BusinessClassUpgrade
