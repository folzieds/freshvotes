package com.phos.freshvotes.controller;

import com.phos.freshvotes.Entity.User;
import com.phos.freshvotes.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * Created by Folarin on 01/09/2020
 */

@Controller
public class HomeController {

    @Autowired
    ProductService productService;

    @GetMapping("/")
    public String home(){
        return "index";
    }

    @GetMapping("/dashboard")
    public String dashboard(@AuthenticationPrincipal User user, Model model){
        model.addAttribute("products",productService.getProductByUsername(user));
        return "dashboard";
    }
}
