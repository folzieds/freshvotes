package com.phos.freshvotes.controller;

import com.phos.freshvotes.exceptions.ProductServiceException;
import com.phos.freshvotes.service.FeatureService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by Folarin on 13/10/2020
 */
@RequestMapping("/products/{productId}/features")
@Controller
public class FeatureController {

    @Autowired
    private FeatureService featureService;

    @PostMapping("/")
    public String createFeature(@PathVariable Long productId) throws ProductServiceException {

        featureService.createFeature(productId);
        return "redirect:/feature";
    }

    @GetMapping("/{featureId}")
    public String getFeature(@PathVariable Long featureId, Model model){

        model.addAttribute("feature",featureService.getFeature(featureId));
        return "feature";
    }
}
