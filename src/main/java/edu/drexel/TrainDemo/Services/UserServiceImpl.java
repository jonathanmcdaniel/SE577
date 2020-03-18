package edu.drexel.TrainDemo.Services;

import edu.drexel.TrainDemo.Utils;
import edu.drexel.TrainDemo.models.Address;
import edu.drexel.TrainDemo.models.UserEntity;
import edu.drexel.TrainDemo.repositories.AddressRepository;
import edu.drexel.TrainDemo.repositories.UserRepository;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.stereotype.Service;
import sun.rmi.rmic.Util;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private Logger logger;

    @Autowired
    private UserRepository userRepo;

    @Autowired
    private AddressRepository addressRepo;

    @Override
    public List<UserEntity> getUsers() {
        List<UserEntity> allUsers = new ArrayList<>();
        this.userRepo.findAll().forEach(allUsers::add);
        return allUsers;
    }

    @Override
    public UserEntity getUser(OAuth2User principal) {
        long id = Utils.intToLong(principal.getAttribute("id"));
        return getUser(id);
    }

    @Override
    public UserEntity getUser(long id) {
        UserEntity user = this.userRepo.findByExternalId(id);

        // TODO: If user does not exist, then create the user. Possibly
        if (user == null) {
            //user = createUser(id, "x", "x");
        } else {
            System.out.println("getUser: " + user.getExternalId() + " | " + user.getFirstName() + " | " + user.getLastName());
        }

        return user;
    }

    @Override
    public UserEntity createUser(long id, String firstName, String lastName) {
        UserEntity newUser = new UserEntity(firstName, lastName, id);
        System.out.println("createUser: " + newUser.getExternalId() + " | " + newUser.getFirstName() + " | " + newUser.getLastName());
        this.userRepo.save(newUser);
        getUser(id);
        return newUser;
    }

    @Override
    public void saveUser(OAuth2User principal, UserEntity newUser) {
        UserEntity oldUser = getUser(principal);
        saveUser(oldUser, newUser);
    }

    @Override
    public void saveUser(UserEntity oldUser, UserEntity newUser) {
        // TODO: Implement this
    }

    @Override
    public void removeUser(OAuth2User principal) {
        this.userRepo.delete(getUser(principal));
    }


    @Override
    public List<Address> getBillingAddresses(OAuth2User principal) {
        return this.addressRepo.findAddressesByUserIdAndIsBilling(this.getIdFromOAuth(principal), true);
    }

    @Override
    public List<Address> getMailingAddresses(OAuth2User principal) {
        return this.addressRepo.findAddressesByUserIdAndIsBilling(this.getIdFromOAuth(principal), false);
    }

    @Override
    public void saveAddress(OAuth2User principal, Address address) {
        this.addressRepo.save(address);
    }

    /**
     * Helper method to get user id from principal.
     * @param principal
     * @return
     */
    public long getIdFromOAuth(OAuth2User principal) {
        return Utils.intToLong(principal.getAttribute("id"));
    }

}
