package com.sports.User.Service;

import com.sports.User.Model.User;
import com.sports.User.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * Created by sahin on 07.03.2018.
 */
@Service
public class UserService implements UserServiceImpl{

    @Autowired
    UserRepository userRepository;

    @Override
    public void addUser(User user) {
        userRepository.save(user);
    }

    @Override
    public void deleteUser(Integer id) {
        userRepository.deleteById(id);
    }

    @Override
    public void updateUser(Integer id, User user) {
        Optional<User> userTempObject = userRepository.findById(id);
        if(userTempObject == null) {
            throw new RuntimeException();
        }
        else {
            userRepository.deleteById(id);
            userRepository.save(user);
        }
    }

    @Override
    public Optional<User> getUserById(Integer id) {
        return userRepository.findById(id);
    }

    @Override
    public List<User> findAllUsers() {
        return (List<User>) userRepository.findAll();
    }
}
