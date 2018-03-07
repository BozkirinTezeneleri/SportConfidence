package com.sports.User.Model;


import lombok.Data;

import javax.persistence.Entity;

@Entity
@Data
public class User {
    private int Id;
    private String Name;
    private String Surname;
    private String Password;
    private String Email;
    private String Phone;
}
