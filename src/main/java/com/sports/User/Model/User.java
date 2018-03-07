package com.sports.User.Model;


import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.Pattern;

@Entity
@Data
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int userId;
    private String Name;
    private String Surname;
    private String Password;
    @Email(message = "Invalid email address!!")
    private String userEmail;
    @Pattern(regexp="(^$|[0-9]{10})")
    private String Phone;
    @Enumerated(EnumType.STRING)
    private Role role;
}
