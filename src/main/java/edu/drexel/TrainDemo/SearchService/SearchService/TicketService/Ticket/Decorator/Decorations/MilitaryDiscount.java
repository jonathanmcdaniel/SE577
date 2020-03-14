// package
// imports

public class MilitaryDiscount extends TicketDecorator
{
    public militaryDiscount(Ticket ticket)
    {
        super(ticket);
    }

    public String decorate()
    {
        return super.decorate() + decorateWithMilitaryDiscount();
    }

    public String decorateWithMilitaryDiscount()
    {
        return "Military Discount";
    }

}  // End of MilitaryDiscount
