package com.sports;

import com.sports.User.Model.Role;
import com.sports.User.Model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.security.crypto.password.PasswordEncoder;


@ComponentScan(basePackages = "com.sports")
@SpringBootApplication
public class SportconfidenceApplication extends SpringBootServletInitializer {
	private static Class applicationClass = SportconfidenceApplication.class;

	public static void main(String[] args) {


		SpringApplication.run(SportconfidenceApplication.class, args);
	}
}
