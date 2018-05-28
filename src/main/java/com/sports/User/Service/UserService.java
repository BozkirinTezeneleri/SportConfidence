package com.sports.User.Service;

import com.sports.User.Model.User;
import com.sports.User.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessResourceFailureException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * Created by sahin on 07.03.2018.
 */
@Service
public class UserService implements UserServiceImpl,UserDetailsService{

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    UserRepository userRepository;

    @Override
    public void addUser(User user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        userRepository.save(user);

    }

    @Override
    public void deleteUser(Integer id) {
        userRepository.deleteById(id);
    }

    @Override
    public void updateUser(Integer id, User user) {
        User userTempObject = userRepository.findById(id).orElseThrow(()->new DataAccessResourceFailureException("Data is not available"));
        if(userTempObject == null) {
            throw new RuntimeException();
        }
        else {
            userTempObject.setUserId(id);
            userTempObject.setUsername(user.getUsername());
            userTempObject.setEmail(user.getEmail());
            userTempObject.setPassword(user.getPassword());
            userTempObject.setPhone(user.getPhone());
            userTempObject.setRole(user.getRole());
            userTempObject.setSurname(user.getSurname());
            userRepository.save(userTempObject);
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

    @Override
    public Optional<User> getUserByName(String name) {
        return userRepository.findByUsername(name);
    }

    @Override
    public User getLoginUserInformation(String username, String password) {
        Optional<User> userOptional = userRepository.findByUsername(username);

        if (!userOptional.isPresent()) {
            return null;
        }

        else {
            String storedBcryptPassword,storedUsername;
            storedBcryptPassword = userOptional.get().getPassword();
            storedUsername = userOptional.get().getUsername();
            if(passwordEncoder.matches(password,storedBcryptPassword) && username.equals(storedUsername)){
                return userOptional.get();
            }
            else return null;
        }
    }


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<User> userOptional = userRepository.findByUsername(username);

        if (!userOptional.isPresent()) {
            return null;
        }

        else {
            return userOptional.get();
        }
    }
}
