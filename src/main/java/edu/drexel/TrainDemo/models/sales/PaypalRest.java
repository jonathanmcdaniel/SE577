/*

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class PayPalRest implements PaymentModule {
	public void validateModuleConfiguration(
			IntegrationConfiguration integrationConfiguration,
			TrainStation station) throws IntegrationException {
		
		
		List<String> errorFields = null;
		
		Map<String,String> keys = integrationConfiguration.getIntegrationKeys();
		if(keys==null || StringUtils.isBlank(keys.get("user"))) {
			errorFields = new ArrayList<String>();
			errorFields.add("user");
		}
		
		if(keys==null || StringUtils.isBlank(keys.get("secret"))) {
			if(errorFields==null) {
				errorFields = new ArrayList<String>();
			}
			errorFields.add("secret");
		}
		

		if(errorFields!=null) {
			IntegrationException ex = new IntegrationException(IntegrationException.ERROR_VALIDATION_SAVE);
			ex.setErrorFields(errorFields);
			throw ex;
			
		}

	}

	public Transaction initTransaction(TrainStation station, Passenger passenger,
			BigDecimal amount, Payment payment,
			IntegrationConfiguration configuration, IntegrationModule module)
			throws IntegrationException {
		return null;
	}

	public Transaction authorize(TrainStation station, Passenger passenger,
			List<ShoppingCartItem> items, BigDecimal amount, Payment payment,
			IntegrationConfiguration configuration, IntegrationModule module)
			throws IntegrationException {
		
		return null;

		APIContext apiContext = null;
		String accessToken = null;
		
		try {
			
			String userID = configuration.getIntegrationKeys().get("user");
			String secretCode = configuration.getIntegrationKeys().get("secret");
			
			accessToken = getAccessToken(userID, secretCode);
		
			apiContext = new APIContext(accessToken);
			
			
			 String requestId = Long.toString(System.nanoTime(); APIContext
			 apiContext = new APIContext(accessToken, requestId ));
			 
			String authorizationID = null;
		
			Details details = new Details();
			details.setTax();
			details.setDiscount();
			
			String sAmount = productPriceUtils.getAdminFormatedAmount(station, amount);
			
			
			Amount amnt = new Amount();
			amnt.setCurrency(station.getCurrency().getCode());
			amnt.setTotal(sAmount);
			
			com.paypal.api.payments.Transaction transaction = new com.paypal.api.payments.Transaction();
			transaction.setAmount(amnt);
			
			transaction.setDescription("This is the payment transaction description.");
			
			List<com.paypal.api.payments.Transaction> transactions = new ArrayList<com.paypal.api.payments.Transaction>();
			transactions.add(transaction);
		
			Payer payer = new Payer();
			payer.setPaymentMethod("paypal");
			
			com.paypal.api.payments.Payment ppayment = new com.paypal.api.payments.Payment();
			ppayment.setIntent("sale");
			ppayment.setPayer(payer);
			ppayment.setTransactions(transactions);
		
			RedirectUrls redirectUrls = new RedirectUrls();
			String guid = UUID.randomUUID().toString().replaceAll("-", "");
			redirectUrls.setCancelUrl(req.getScheme() + "://"
					+ req.getServerName() + ":" + req.getServerPort()
					+ req.getContextPath() + "/paymentwithpaypal?guid=" + guid);
			redirectUrls.setReturnUrl(req.getScheme() + "://"
					+ req.getServerName() + ":" + req.getServerPort()
					+ req.getContextPath() + "/paymentwithpaypal?guid=" + guid);
			payment.setRedirectUrls(redirectUrls);
			
			try {
				Payment createdPayment = payment.create(apiContext);
				LOGGER.info("Created payment with id = "
						+ createdPayment.getId() + " and status = "
						+ createdPayment.getState());
				
				Iterator<Links> links = createdPayment.getLinks().iterator();
				while (links.hasNext()) {
					Links link = links.next();
					if (link.getRel().equalsIgnoreCase("approval_url")) {
						req.setAttribute("redirectURL", link.getHref());
					}
				}
				req.setAttribute("response", Payment.getLastResponse());
				map.put(guid, createdPayment.getId());
			} catch (PayPalRESTException e) {
				req.setAttribute("error", e.getMessage());
			}
		} catch (PayPalRESTException e) {
			throw new IntegrationException(e);
		}	
		
	}


	public Transaction capture(TrainStation station, Passenger passenger,
			List<ShoppingCartItem> items, BigDecimal amount, Payment payment, Transaction transaction,
			IntegrationConfiguration configuration, IntegrationModule module)
			throws IntegrationException {
		return null;
	}

	public Transaction authorizeAndCapture(TrainStation station,
			Passenger passenger, List<ShoppingCartItem> items, BigDecimal amount, Payment payment,
			IntegrationConfiguration configuration, IntegrationModule module)
			throws IntegrationException {
		return null;
	}
	private String getAccessToken(String userID, String secretCode) throws Exception {

		return null;
	}

	public Transaction capture(TrainStation station, Passenger passenger,
			Order order, Transaction capturableTransaction,
			IntegrationConfiguration configuration, IntegrationModule module)
			throws IntegrationException {
		return null;
	}

}
*/
