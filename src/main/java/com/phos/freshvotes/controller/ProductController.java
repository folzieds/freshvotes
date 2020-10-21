package com.phos.freshvotes.controller;

import com.phos.freshvotes.Entity.Product;
import com.phos.freshvotes.Entity.User;
import com.phos.freshvotes.exceptions.ProductServiceException;
import com.phos.freshvotes.service.ProductService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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

    private Logger logger = LoggerFactory.getLogger(ProductController.class);

    @Autowired
    ProductService productService;

    @GetMapping("/products")
    public String products(@AuthenticationPrincipal User user,Model model){
        model.addAttribute("products",productService.getProductByUsername(user));
        return "products";
    }

    @GetMapping("/products/{id}")
    public  String product(Model model, @PathVariable Long id, HttpServletResponse response) throws IOException {
        try {
            model.addAttribute("product",productService.getProduct(id));
        } catch (ProductServiceException e) {
            logger.error("Could not find product with Id " + id, e);
            response.sendError(HttpStatus.NOT_FOUND.value(),e.getMessage());
        }
        return "product";
    }

    @GetMapping("/prod/{name}")
    public String productUserView(Model model, @PathVariable String name) {
        try {
            Product product = productService.getProduct(name);
            model.addAttribute("product",product);
        } catch (ProductServiceException e) {
            logger.error("Could not find product...", e);
        }
        return "productsUserView";
    }

    @PostMapping("/products/{id}")
    public String saveProduct(@PathVariable Long id, Product product, Model model, HttpServletResponse response) throws IOException {
        try {
            model.addAttribute("product", productService.update(id,product));
        } catch (ProductServiceException e) {
            response.sendError(HttpStatus.NOT_FOUND.value(),e.getMessage());
        }
        return "redirect:/products/" + product.getId();
    }

    @PostMapping("/products")
    public String createProduct(@AuthenticationPrincipal User user){

        return "redirect:/products/" + productService.create(user).getId();
    }
}
