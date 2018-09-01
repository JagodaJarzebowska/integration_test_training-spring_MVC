package com.sda.twittermvc.controllers;

import com.sda.twittermvc.model.Message;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value = "/message")
public class MessageController {

    @GetMapping
    public void message(@ModelAttribute Message message){

    }

    @PostMapping
    public String createMessage(@ModelAttribute Message message){
        return "show-message";
    }

//    @PostMapping
//    public String createMessage(){
//        return "showMessage";
//    }

}
