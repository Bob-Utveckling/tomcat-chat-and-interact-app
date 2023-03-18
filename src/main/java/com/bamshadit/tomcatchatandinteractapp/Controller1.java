package com.bamshadit.tomcatchatandinteractapp;

import com.bamshadit.tomcatchatandinteractapp.model.User;
//import com.bamshadit.tomcatchatandinteractapp.repository.UserRepository;
import com.bamshadit.tomcatchatandinteractapp.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.websocket.server.PathParam;

@Controller
public class Controller1 {

    @Autowired
    UserRepository userRepository;

    //@GetMapping("/start")
    @RequestMapping(value="/admin", method=RequestMethod.GET)
    public String admin() {

        System.out.println("Admin page access...");
        return "admin";
    }

    @RequestMapping(value="/user", method=RequestMethod.GET)
    public String user() {

        System.out.println("User page access...");
        return "user";
    }

    @RequestMapping(value="/start", method=RequestMethod.GET)
    public String start() {

        System.out.println("Start");
        return "index2";
    }

    //@GetMapping("/save/{username}")
    @RequestMapping(value="/save/{username}", method=RequestMethod.GET)
    public ResponseEntity save(@PathVariable String username) {
        System.out.println("save a record for username: '" + username + "'");
        User user = new User("Test name",username,"test@test.com");
        userRepository.save(user);
        return ResponseEntity.status(HttpStatus.OK).body(user);
        //return "user from database: " + user.getName() + " -- email: " + user.getEmail();
        //return "You are now logged in - user: " + username;
    }

    //@GetMapping("/index2")
    @RequestMapping(value="/index2", method=RequestMethod.GET)
    public String login(Model model) {
        model.addAttribute("message", "Hello User dynamic message");
        System.out.println("- return Thymeleaf index2 html page");
        return "index2"; //view
    }


    //@GetMapping("/login/{username}")
    @RequestMapping(value="/login/{username}", method=RequestMethod.GET)
    public ResponseEntity login(@PathVariable String username) {
        System.out.println("Check credentials against db for username: '" + username + "' and do Login");
        User user = userRepository.findUser(username);
        return ResponseEntity.status(HttpStatus.OK).body(user);
        //return "user from database: " + user.getName() + " -- email: " + user.getEmail();
        //return "You are now logged in - user: " + username;
    }


    //@GetMapping("/userProfile")
    @RequestMapping(value="/userProfile", method=RequestMethod.GET)
    public String userprofile() {
        System.out.println("Show User Profile");
        String firstname = "Bamshad";
        System.out.println ("Your profile. -- " + "First name: " + firstname);
        return "index2";
    }

    //haven't run this method. just copied from https://www.javatpoint.com/spring-boot-thymeleaf-view It should work, used ModelAndView
    /*@RequestMapping(value="/save", method=RequestMethod.POST)
    public ModelAndView save(@ModelAttribute User user)
    {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("user-data");
        modelAndView.addObject("user", user);
        return modelAndView;
    }*/
}
