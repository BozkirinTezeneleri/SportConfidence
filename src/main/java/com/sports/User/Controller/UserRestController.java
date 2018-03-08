package com.sports.User.Controller;

import com.sports.User.Model.User;
import com.sports.User.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

/**
 * Created on 08-March-2018
 *
 * @author eray
 */
@RestController
@RequestMapping("/users")
public class UserRestController {

    @Autowired
    private UserService userService;

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<User> getAllUsers(){
       return userService.findAllUsers();
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Optional<User> getUserById(@PathVariable Integer id){
        return userService.getUserById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void addUser(@Valid @RequestBody User user){
        userService.addUser(user);
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public void updateUserById(@PathVariable Integer id, @RequestBody User user){
        userService.updateUser(id,user);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void deleteUserById(@PathVariable Integer id){
        userService.deleteUser(id);
    }
}
