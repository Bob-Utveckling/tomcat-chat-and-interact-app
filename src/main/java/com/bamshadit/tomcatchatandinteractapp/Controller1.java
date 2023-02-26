package com.bamshadit.tomcatchatandinteractapp;

import com.bamshadit.tomcatchatandinteractapp.model.User;
//import com.bamshadit.tomcatchatandinteractapp.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.websocket.server.PathParam;

@RestController
public class Controller1 {

    //@Autowired
    //UserRepository userRepository;

    @GetMapping("/start")
    public String start() {

        System.out.println("Start");
        return "Start page";
    }

    @GetMapping("/login/{username}")
    public String login(@PathVariable String username) {
        System.out.println("Check credentials against db for username: '" + username + "' and do Login");
        //User user = userRepository.findUser(username);
        //return "You are now logged in - user: " + user.getName();
        return "You are now logged in - user: " + username;
    }

    @GetMapping("/userProfile")
    public String userprofile() {
        System.out.println("Show User Profile");
        String firstname = "Bamshad";
        return ("Your profile. -- " + "First name: " + firstname);
    }
}
