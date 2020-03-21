package edu.drexel.TrainDemo.services.users;

import edu.drexel.TrainDemo.Utils;
import edu.drexel.TrainDemo.models.users.Address;
import edu.drexel.TrainDemo.models.users.Group;
import edu.drexel.TrainDemo.models.users.GroupType;
import edu.drexel.TrainDemo.models.users.UserEntity;
import edu.drexel.TrainDemo.repositories.users.AddressRepository;
import edu.drexel.TrainDemo.repositories.users.GroupRepository;
import edu.drexel.TrainDemo.repositories.users.UserRepository;

import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.parameters.P;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.stereotype.Service;

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

    @Autowired
    private GroupRepository groupRepo;

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
    public UserEntity createUser(long id, String firstName, String lastName, String phoneNumber, Long groupId) {
        //Long groupid = this.groupRepo.findByGroupName("DEFAULT").getGroupId();
        UserEntity newUser = new UserEntity(firstName, lastName, phoneNumber, id, groupId);
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
        System.out.println(newUser.toString());
        oldUser.setFirstName(newUser.getFirstName());
        oldUser.setLastName(newUser.getLastName());
        oldUser.setPhoneNumber(newUser.getPhoneNumber());
        if (newUser.getGroupId() != null) {
            oldUser.setGroupId(newUser.getGroupId());
        }
        System.out.println(oldUser.toString());
        this.userRepo.save(oldUser);
    }

    @Override
    public boolean isAllowedAdminPanel(UserEntity user) {
        Group group = this.groupRepo.findGroupByGroupId(user.getGroupId());
        System.out.println(group.getGroupType());
        return (group.getGroupType() == GroupType.ADMIN || group.getGroupType() == GroupType.EMPLOYEE);
    }

    @Override
    public void changeGroupId(Long userid, Long groupId) {
        UserEntity user = this.getUser(userid);
        user.setGroupId(groupId);
        this.userRepo.save(user);
    }

    @Override
    public void removeUser(long id) {
        System.out.println(id);
        UserEntity removal = this.userRepo.findById(id);
        if (removal != null) {
            this.userRepo.delete(removal);
        }
    }

    @Override
    public int getNumUsersInGroup(long groupId) {
        return this.userRepo.countByGroupId(groupId);
    }

    @Override
    public List<Address> getBillingAddresses(OAuth2User principal) {
        return this.addressRepo.findAddressesByUserIdAndIsBilling(this.getIdFromOAuth(principal), true);
    }

    @Override
    public List<Address> getShippingAddresses(OAuth2User principal) {
        return this.addressRepo.findAddressesByUserIdAndIsBilling(this.getIdFromOAuth(principal), false);
    }

    @Override
    public void saveAddress(OAuth2User principal, Address address) {
        this.addressRepo.save(address);
    }

    @Override
    public void deleteAddress(List<String> params, long userid) {
        this.addressRepo.deleteAddressByNameAndLine1AndCityAndZipAndUserId(params.get(0), params.get(1), params.get(2), params.get(3), userid);
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
