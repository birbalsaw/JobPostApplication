package com.bmrgroup.SpringSecPractice001.controller;

import com.bmrgroup.SpringSecPractice001.model.User;
import com.bmrgroup.SpringSecPractice001.service.JwtService;
import com.bmrgroup.SpringSecPractice001.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private UserService service;

    @Autowired
    private JwtService jwtService;

    @PostMapping("register")
    public User saveUser(@RequestBody User user){

        return service.saveUser(user);
    }

    @PostMapping("login")
    public String login(@RequestBody User user){
        Authentication authentication = authenticationManager
                .authenticate(new UsernamePasswordAuthenticationToken(user.getUsername(),user.getPassword()));

        if(authentication.isAuthenticated()){
//            return "Success";
            return jwtService.generateToken(user.getUsername());
        }

        else return "log in failed";
    }
}
