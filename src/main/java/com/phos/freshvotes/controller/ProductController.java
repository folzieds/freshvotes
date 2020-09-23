package com.phos.freshvotes.controller;

import com.phos.freshvotes.Entity.Product;
import com.phos.freshvotes.Entity.User;
import com.phos.freshvotes.exceptions.ProductServiceException;
import com.phos.freshvotes.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by Folarin on 22/09/2020
 */
@Controller
public class ProductController {

    @Autowired
    ProductService productService;

    @GetMapping("/products")
    public String products(Model model){
        return "product";
    }

    @GetMapping("/products/{id}")
    public  String product(Model model, @PathVariable Long id, HttpServletResponse response) throws IOException {
        try {
            model.addAttribute("product",productService.getProduct(id));
        } catch (ProductServiceException e) {
            response.sendError(HttpStatus.NOT_FOUND.value(),e.getMessage());
        }
        return "product";
    }

    @PostMapping("/products/{id}")
    public String saveProduct(@PathVariable Long id, Product product){
        
        return "redirect:/products/" + product.getId();
    }

    @PostMapping("/products")
    public String createProduct(@AuthenticationPrincipal User user){

        return "redirect:/products/" + productService.create(user).getId();
    }
}
