package edu.drexel.TrainDemo.Services;

import edu.drexel.TrainDemo.models.UserEntity;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface UserService {
    List<UserEntity> getUsers();
    UserEntity getUser(OAuth2User principal);
    UserEntity getUser(long id);
    UserEntity createUser(long id, String firstName, String lastName);
    void saveUser(OAuth2User principal, UserEntity newUser);
    void saveUser(UserEntity user, UserEntity newUser);
    void removeUser(OAuth2User principal);
}
