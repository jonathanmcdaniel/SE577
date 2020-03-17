package edu.drexel.TrainDemo.models;

import java.math.BigDecimal;
import java.util.List;

public class PaymentModule {
	
	public void validateModule(IntegrationConfiguration integrationConfiguration, TrainTicket ticket) throws IntegrationException;
	
	public Transaction initTransaction(
			TrainTicket ticket, Passenger passenger, BigDecimal amount, Payment payment, IntegrationConfiguration configuration, IntegrationModule module)
					throws IntegrationException;
	
	public Transaction authorize(
			TrainTicket ticket, Passenger passenger, List<ShoppingCartItem> item, BigDecimal amount, Payment payment, IntegrationConfiguration configuration, IntegrationModule module)
					throws IntegrationException;
	
	public Transaction capture(
			TrainTicket ticket, Passenger passenger, Order order, Transaction capturableTransaction, IntegrationConfiguration configuration, IntegrationModule module)
					throws IntegrationException;
	
	public Transaction authorizeAndCapture(
			TrainTicket ticket, Passenger passenger, List<ShoppingCartItem> item, BigDecimal amount, Payment payment, IntegrationConfiguration configuration, IntegrationModule module)
					throws IntegrationException;
	
	public Transaction refund(
			boolean partial, TrainTicket ticket, Transaction transaction, Order order, BigDecimal amount,IntegrationConfiguration configuration, IntegrationModule module)
					throws IntegrationException;

}
