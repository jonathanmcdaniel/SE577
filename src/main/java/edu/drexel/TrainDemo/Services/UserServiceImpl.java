package edu.drexel.TrainDemo.Services;

import edu.drexel.TrainDemo.models.User;
import edu.drexel.TrainDemo.repositories.UserRepository;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.oauth2.core.user.OAuth2User;

import java.util.ArrayList;
import java.util.List;

public class UserServiceImpl implements UserService {

    @Autowired
    private Logger logger;

    @Autowired
    private UserRepository userRepo;

    @Override
    public List<User> getUsers() {
        List<User> allUsers = new ArrayList<>();
        this.userRepo.findAll().forEach(allUsers::add);
        return allUsers;
    }

    @Override
    public User getUser(OAuth2User principal) {
        long id = principal.getAttribute("id");
        return getUser(id);
    }

    @Override
    public User getUser(long id) {
        User user = this.userRepo.findById(id);

        // TODO: If user does not exist, then create the user.
        if (user == null) {
            user = createUser(id);
        }

        return user;
    }

    @Override
    public User createUser(long id) {
        return new User("John", "Doe", id);
    }

    @Override
    public void saveUser(OAuth2User principal, User newUser) {
        User oldUser = getUser(principal);
        saveUser(oldUser, newUser);
    }

    @Override
    public void saveUser(User oldUser, User newUser) {
        // TODO: Implement this
    }

    @Override
    public void removeUser(OAuth2User principal) {
        this.userRepo.delete(getUser(principal));
    }
}
