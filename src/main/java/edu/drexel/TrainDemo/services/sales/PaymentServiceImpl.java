package edu.drexel.TrainDemo.services.sales;

import edu.drexel.TrainDemo.models.sales.CreditCard;
import edu.drexel.TrainDemo.repositories.sales.CreditCardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PaymentServiceImpl implements PaymentService{

    @Autowired
    CreditCardRepository creditCardRepo;

    public void addCreditCard(long userid, List<String> params) {
        CreditCard card = new CreditCard(userid, params);
        this.creditCardRepo.save(card);
    }

    @Override
    public List<CreditCard> getCreditCards(Long userid) {
        return this.creditCardRepo.findAllByUserId(userid);
    }
}









/*
import java.math.BigDecimal;
import java.util.List;

public interface PaymentService {
	Payment getPaymentMethods();
	
	Map<String, IntegrationConfiguration> getPaymentModulesConfigured();

	Transaction processPayment(Passenger, passenger, TrainTicket, ticket, Payment payment, List<ShoppingCartItem> items, Order order); throws ServiceException;
	Transaction processDiscounts(Order order, Passenger passenger, TrainTicket ticket, BigDecimal amount) throws ServiceException;
	
	IntegrationModule getPaymentMethodType()
	throws ServiceException;
	
	IntegrationModule getPaymentMethodByCode()
	throws ServiceException;
	
	void savePaymentModuleConfiguration()
	throws ServiceException;
	
	void validateCreditCard(String number, CreditCardType creditCard, String month, String date)
	throws ServiceException;
	
	void validateDiscount(String passenger, String discountType, String number, String date)
	throws ServiceException;
	
	void validateVoucher(String passenger, String order)
	throws ServiceException;
	
	Transaction processCapturePayment(oder order, Passenger passenger)
	throws ServiceException;
	
	Transaction initTransaction(Order order, Passenger passenger, Payment payment) 
	throws ServiceException;
	
	List<PaymentMethod>getAcceptedPaymentMethods()
	throws ServiceException;
	
	PaymentModule getPaymentModule(String paymentModuleCode)
	throws ServiceException;
  
  }
  */
