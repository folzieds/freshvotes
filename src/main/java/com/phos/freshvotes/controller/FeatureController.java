package com.phos.freshvotes.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by Folarin on 13/10/2020
 */
@RequestMapping("/products/{productId}/features")
@Controller
public class FeatureController {

    @PostMapping("/")
    public String createFeature(){

        return "redirect:/feature";
    }
}
