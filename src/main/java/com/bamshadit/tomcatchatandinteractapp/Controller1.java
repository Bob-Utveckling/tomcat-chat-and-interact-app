package com.bamshadit.tomcatchatandinteractapp;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller1 {

    @GetMapping("/start")
    public String start() {

        System.out.println("Start");
        return "Start page";
    }
}
