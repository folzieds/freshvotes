package com.phos.freshvotes.controller;

import com.phos.freshvotes.Entity.Feature;
import com.phos.freshvotes.exceptions.FeatureServiceException;
import com.phos.freshvotes.exceptions.ProductServiceException;
import com.phos.freshvotes.service.FeatureService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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
@Controller
@RequestMapping("/products/{productId}/features")
public class FeatureController {

    Logger logger = LoggerFactory.getLogger(FeatureController.class);

    @Autowired
    private FeatureService featureService;

    @PostMapping("")
    public String createFeature(@PathVariable Long productId) throws ProductServiceException {
        Feature feature = featureService.createFeature(productId);
        return "redirect:/products/"+productId+"/features/" + feature.getId();
    }

    @GetMapping("{featureId}")
    public String getFeature(@PathVariable Long productId,@PathVariable Long featureId, Model model){

        try {
            model.addAttribute("feature",featureService.getFeature(featureId));
        } catch (FeatureServiceException e) {
            logger.error("could not get feature with id" + featureId);
        }
        return "feature";
    }

    @PostMapping("{featureId}")
    public String updateFeature(Feature feature,@PathVariable Long productId,@PathVariable Long featureId, Model model){
        try {
            feature = featureService.updateFeature(feature);
            model.addAttribute("feature",feature);
        } catch (Exception e) {
            logger.error("could not get feature with id" + featureId);
        }
        return "redirect:/products/"+productId+"/features/" + featureId;
    }
}
