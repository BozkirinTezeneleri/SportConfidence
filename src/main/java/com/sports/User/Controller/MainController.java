package com.sports.User.Controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("Sports")
public class MainController {

    @GetMapping("")
    public String index(){
        return "Başladıkkkk";
    }
}
