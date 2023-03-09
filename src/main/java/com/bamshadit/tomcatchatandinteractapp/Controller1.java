package com.bamshadit.tomcatchatandinteractapp;

import com.bamshadit.tomcatchatandinteractapp.model.User;
//import com.bamshadit.tomcatchatandinteractapp.repository.UserRepository;
import com.bamshadit.tomcatchatandinteractapp.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.websocket.server.PathParam;

@RestController
public class Controller1 {

    @Autowired
    UserRepository userRepository;

    @GetMapping("/start")
    public String start() {

        System.out.println("Start");
        return "Start page";
    }

    @GetMapping("/save/{username}")
    public ResponseEntity save(@PathVariable String username) {
        System.out.println("save a record for username: '" + username + "'");
        User user = new User("Test name",username,"test@test.com");
        userRepository.save(user);
        return ResponseEntity.status(HttpStatus.OK).body(user);
        //return "user from database: " + user.getName() + " -- email: " + user.getEmail();
        //return "You are now logged in - user: " + username;
    }

    @GetMapping("/login/{username}")
    public ResponseEntity login(@PathVariable String username) {
        System.out.println("Check credentials against db for username: '" + username + "' and do Login");
        User user = userRepository.findUser(username);
        return ResponseEntity.status(HttpStatus.OK).body(user);
        //return "user from database: " + user.getName() + " -- email: " + user.getEmail();
        //return "You are now logged in - user: " + username;
    }


    @GetMapping("/userProfile")
    public String userprofile() {
        System.out.println("Show User Profile");
        String firstname = "Bamshad";
        return ("Your profile. -- " + "First name: " + firstname);
    }
}
