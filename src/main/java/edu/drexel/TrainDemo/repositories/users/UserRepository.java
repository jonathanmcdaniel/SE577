package edu.drexel.TrainDemo.repositories.users;

import edu.drexel.TrainDemo.models.users.UserEntity;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface UserRepository extends CrudRepository<UserEntity, Long> {

    List<UserEntity> findByLastName(String lastName);
    UserEntity findById(long id);
    UserEntity findByExternalId(long externalId);
}
