package edu.drexel.TrainDemo.services.sales;

import com.stripe.model.Charge;
import org.springframework.stereotype.Service;

@Service
public interface StripeService {

    Charge chargeCard(String token, double amount) throws Exception;
}
