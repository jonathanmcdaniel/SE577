// package
// imports

public class ChildDiscount extends TicketDecorator
{
    public childDiscount(Ticket ticket)
    {
        super(ticket);
    }

    public String decorate()
    {
        return super.decorate() + decorateWithChildDiscount();
    }

    public String decorateWithChildDiscount()
    {
        return "Child Discount";
    }

}  // End of ChildDiscount
