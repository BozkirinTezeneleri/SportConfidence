package com.sports.User.Service;

import com.sports.User.Model.User;

import java.util.List;
import java.util.Optional;

/**
 * Created by sahin on 07.03.2018.
 */

public interface UserServiceImpl {
    public void addUser(User user);
    public void deleteUser(Integer id);
    public void updateUser(Integer id, User user);
    public Optional<User> getUserById(Integer id);
    public List<User> findAllUsers();
    public Optional<User> getUserByName(String username);

    User getLoginUserInformation(String username, String password);
}
