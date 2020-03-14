// package
// imports

public class SeniorCitizenDiscount extends TicketDecorator
{
    public seniorCitizenDiscount(Ticket ticket)
    {
        super(ticket);
    }

    public String decorate()
    {
        return super.decorate() + decorateWithSeniorCitizenDiscount();
    }

    public String decorateWithSeniorCitizenDiscount()
    {
        return "Senior Citizen Discount";
    }

}  // End of SeniorCitizenDiscount
