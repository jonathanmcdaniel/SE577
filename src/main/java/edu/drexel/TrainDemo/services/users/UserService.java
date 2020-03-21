package edu.drexel.TrainDemo.services.users;

import edu.drexel.TrainDemo.models.users.UserEntity;
import edu.drexel.TrainDemo.models.users.Address;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface UserService {
    // User Functions
    List<UserEntity> getUsers();
    UserEntity getUser(OAuth2User principal);
    UserEntity getUser(long id);
    UserEntity createUser(long id, String firstName, String lastName, String phoneNumber, Long groupId);
    void saveUser(OAuth2User principal, UserEntity newUser);
    void saveUser(UserEntity user, UserEntity newUser);
    void removeUser(long id);

    int getNumUsersInGroup(long groupId);
    boolean isAllowedAdminPanel(UserEntity userEntity);
    void changeGroupId(Long userid, Long groupId);

    // Address Functions
    List<Address> getBillingAddresses(OAuth2User principal);
    //List<Address> getBillingAddresses(long userid);
    List<Address> getShippingAddresses(OAuth2User principal);
    //List<Address> getShippingAddresses(long userid);
    void saveAddress(OAuth2User principal, Address address);
    void deleteAddress(List<String> params, long userid);
}
