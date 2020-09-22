package com.phos.freshvotes.controller;

import com.phos.freshvotes.Entity.Product;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

/**
 * Created by Folarin on 22/09/2020
 */
@Controller
public class ProductController {

    @GetMapping("/products")
    public String product(Model model){
        return "product";
    }

    @PostMapping("/products")
    public String createProduct(Product product){

        return "redirect:/products";
    }
}
