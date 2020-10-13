package com.phos.freshvotes.service;

import com.phos.freshvotes.Entity.Feature;
import com.phos.freshvotes.Entity.Product;
import com.phos.freshvotes.exceptions.ProductServiceException;
import com.phos.freshvotes.repositories.FeatureRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by Folarin on 13/10/2020
 */
@Service
public class FeatureServiceImpl implements FeatureService {

    @Autowired
    ProductService productService;

    @Autowired
    FeatureRepository featureRepository;

    @Override
    public Feature getFeatures() {
        return null;
    }

    @Override
    public Feature createFeature(Long productId) {
        try {
            Product product = productService.getProduct(productId);

            Feature feature = new Feature();
            feature.setProduct(product);

            featureRepository.save(feature);
        } catch (ProductServiceException e) {
            e.printStackTrace();
        }
        return null;
    }
}
