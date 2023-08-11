package com.knubisoft.application.user;


import java.security.Principal;
import java.util.List;

public interface UserService {

    boolean userExist(String username);

    User create(User user);

    void updateUser(User user, Principal principal);

    User updateEmail(User user, String email);

    List<User> findAll();

    User findByUsername(String username);


}
