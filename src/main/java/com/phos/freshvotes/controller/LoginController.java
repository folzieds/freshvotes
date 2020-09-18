package com.phos.freshvotes.controller;

import com.phos.freshvotes.Entity.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;


/**
 * Created by Folarin on 01/09/2020
 */

@Controller
public class LoginController {

    @GetMapping("/login")
    public String login(){
        return "login";
    }

    @GetMapping("/register")
    public String register(){
        return "register";
    }

    @PostMapping
    public String createAccount(@ModelAttribute User user){
        return "redirect:/login";
    }
}
