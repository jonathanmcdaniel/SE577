package edu.drexel.TrainDemo.repositories.sales;

import edu.drexel.TrainDemo.models.sales.CreditCard;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface CreditCardRepository extends CrudRepository<CreditCard, Long> {

    List<CreditCard> findAllByUserId(long userId);
    CreditCard findById(long id);


}
