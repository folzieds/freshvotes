package com.phos.freshvotes.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * Created by Folarin on 01/09/2020
 */

@Controller
public class HomeController {

    @GetMapping("/")
    public String home(){
        return "index";
    }
}
