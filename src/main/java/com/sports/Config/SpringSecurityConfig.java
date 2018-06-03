package com.sports.Config;

import com.sports.User.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
/**
 * Created on 18-April-2018
 *
 * @author eray
 */
@Configuration
@EnableWebSecurity
public class SpringSecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private UserService userService;

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userService).passwordEncoder(getPasswordEncoder());
    }

    @Bean
    protected PasswordEncoder getPasswordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Autowired
    private AuthenticationEntryPoint authEntryPoint;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()

                //Login Requests
//                .antMatchers("/login").permitAll()
                .antMatchers("/login/**").permitAll()

                //Users Requests
                .antMatchers(HttpMethod.GET, "/users").hasAnyAuthority("ADMIN,MANAGER,DOCTOR")
                .antMatchers(HttpMethod.GET, "/users/**").hasAnyAuthority("ADMIN,MANAGER,DOCTOR")
                .antMatchers(HttpMethod.POST, "/users").hasAuthority("ADMIN")
                .antMatchers(HttpMethod.PUT, "/users/**").hasAuthority("ADMIN")
                .antMatchers(HttpMethod.DELETE, "/users/**").hasAuthority("ADMIN")
                .antMatchers(HttpMethod.OPTIONS, "/users").permitAll()
                .antMatchers(HttpMethod.OPTIONS, "/users/**").permitAll()

                //Players Requests
                .antMatchers(HttpMethod.GET, "/players").hasAnyAuthority("ADMIN,MANAGER,DOCTOR")
                .antMatchers(HttpMethod.GET, "/players/**").hasAnyAuthority("ADMIN,MANAGER,DOCTOR")
                .antMatchers(HttpMethod.POST, "/players").hasAnyAuthority("ADMIN,DOCTOR")
                .antMatchers(HttpMethod.PUT, "/players/**").hasAnyAuthority("ADMIN,DOCTOR")
                .antMatchers(HttpMethod.DELETE, "/players/**").hasAnyAuthority("ADMIN,DOCTOR")
                .antMatchers(HttpMethod.OPTIONS, "/players").permitAll()
                .antMatchers(HttpMethod.OPTIONS, "/players/**").permitAll()

                //Countries Requests
                .antMatchers(HttpMethod.GET, "/countries").hasAnyAuthority("ADMIN,MANAGER,DOCTOR")
                .antMatchers(HttpMethod.OPTIONS, "/countries").permitAll()

                //Leagues Requests
                .antMatchers(HttpMethod.GET, "/leagues").hasAnyAuthority("ADMIN,MANAGER,DOCTOR")
                .antMatchers(HttpMethod.GET, "/leagues/**").hasAnyAuthority("ADMIN,MANAGER,DOCTOR")
                .antMatchers(HttpMethod.OPTIONS, "/leagues").permitAll()
                .antMatchers(HttpMethod.OPTIONS, "/leagues/**").permitAll()

                //SportClubs Requests
                .antMatchers(HttpMethod.GET, "/sportclubs").hasAnyAuthority("ADMIN,MANAGER,DOCTOR")
                .antMatchers(HttpMethod.GET, "/sportclubs/**").hasAnyAuthority("ADMIN,MANAGER,DOCTOR")
                .antMatchers(HttpMethod.OPTIONS, "/sportclubs").permitAll()
                .antMatchers(HttpMethod.OPTIONS, "/sportclubs/**").permitAll()




//                .antMatchers( "/users").permitAll()
//                .antMatchers( "/users/**").permitAll()
//                .antMatchers( "/players").permitAll()
//                .antMatchers( "/players/**").permitAll()
//                .antMatchers( "/countries").permitAll()
//                .antMatchers( "/countries/**").permitAll()
//                .antMatchers( "/leagues").permitAll()
//                .antMatchers( "/leagues/**").permitAll()
//                .antMatchers( "/sportclubs").permitAll()
//                .antMatchers( "/sportclubs/**").permitAll()
//                .antMatchers("/login").permitAll()

//                .antMatchers(HttpMethod.POST, "/users").hasAuthority("ADMIN")
//                .antMatchers(HttpMethod.PUT, "/users/**").hasAuthority("ADMIN")
//                .antMatchers(HttpMethod.DELETE, "/users/**").hasAuthority("ADMIN")

                .anyRequest().authenticated()
                .and().httpBasic()
                .authenticationEntryPoint(authEntryPoint);
        http.csrf().disable();
        http.headers().frameOptions().disable();

    }

//    @Autowired
//    private PasswordEncoder passwordEncoder;
//
//    @Autowired
//    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
//         auth.inMemoryAuthentication().withUser("eray").password(passwordEncoder.encode("eray")).roles("ADMIN");
//    }

}

