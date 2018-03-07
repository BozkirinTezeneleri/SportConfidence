package com.sports.User.Controller;

import com.sports.User.Model.User;
import com.sports.User.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

/**
 * @author eray
 */
@Controller
@RequestMapping("user")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("users")
    public String getUserList(Model model){
        List<User> optionalUser = userService.findAllUsers();
        model.addAttribute("users",optionalUser);

        return "";
    }

    @GetMapping(value = "/{id}")
    public String getUserById(@PathVariable("id") Integer id, Model model){
        Optional <User> userOptional = userService.getUserById(id);
        if(!userOptional.isPresent()){
            return "user/veriyok";
        }
        else{
            model.addAttribute("user",userOptional.get());
            return "user/showUser";
        }

    }

    @DeleteMapping(value = "/{id}/delete")
    public String getDeleteById(@PathVariable("id") Integer id){
        Optional <User> userOptional = userService.getUserById(id);
        if(!userOptional.isPresent()){
            return "redirect:/veriyok";
        }
        else{
            userService.deleteUser(id);
            return "user/showuser";
        }
    }

    @GetMapping(value = "/{id}/update")
    public String getUpdateById(@PathVariable("id") Integer id, Model model){
        Optional<User> userOptional = userService.getUserById(id);
        if(!userOptional.isPresent()){
            return "redirect:/veriyok";
        }
        else{
            model.addAttribute("userUpdate", userOptional);
            return "user/userUpdate";
        }
    }

    @PutMapping(value = "/{id}/update")
    public String putUpdateById(@Valid @ModelAttribute  User user, BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            return "user/updateUser";
        }
        else{
            userService.updateUser(user.getUserId(),user);
            return "user/showUser";
        }

    }
}
