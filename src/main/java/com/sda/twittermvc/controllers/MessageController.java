package com.sda.twittermvc.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value = "/message")
public class MessageController {

    @GetMapping
    public void message(){

    }

    @PostMapping
    public String createMessage(){
        return "showMessage";
    }
}
