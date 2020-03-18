package edu.drexel.TrainDemo.Services;

import edu.drexel.TrainDemo.models.User;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface UserService {
    List<User> getUsers();
    User getUser(OAuth2User principal);
    User getUser(long id);
    User createUser(long id);
    void saveUser(OAuth2User principal, User newUser);
    void saveUser(User user, User newUser);
    void removeUser(OAuth2User principal);
}
