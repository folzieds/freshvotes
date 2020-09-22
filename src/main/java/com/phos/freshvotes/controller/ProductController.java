package com.phos.freshvotes.controller;

import com.phos.freshvotes.Entity.User;
import com.phos.freshvotes.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

/**
 * Created by Folarin on 22/09/2020
 */
@Controller
public class ProductController {

    @Autowired
    ProductService productService;

    @GetMapping("/products")
    public String product(Model model){
        return "product";
    }

    @PostMapping("/products")
    public String createProduct(@AuthenticationPrincipal User user){

        productService.create(user);
        return "redirect:/products";
    }
}
