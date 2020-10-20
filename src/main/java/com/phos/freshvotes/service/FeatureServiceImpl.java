package com.phos.freshvotes.service;

import com.phos.freshvotes.Entity.Feature;
import com.phos.freshvotes.Entity.Product;
import com.phos.freshvotes.exceptions.ProductServiceException;
import com.phos.freshvotes.repositories.FeatureRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by Folarin on 13/10/2020
 */
@Service
public class FeatureServiceImpl implements FeatureService {

    private Logger logger = LoggerFactory.getLogger(FeatureServiceImpl.class);

    @Autowired
    private ProductService productService;

    @Autowired
    private FeatureRepository featureRepository;

    @Override
    public Feature getFeatures() {
        return null;
    }

    @Override
    public Feature createFeature(Long productId) throws ProductServiceException {
        try {
            Product product = productService.getProduct(productId);

            Feature feature = new Feature();
            feature.setProduct(product);
            product.getFeatures().add(feature);

            return featureRepository.save(feature);
        } catch (ProductServiceException e) {
            throw new ProductServiceException("Product with Id" + productId + " could not be updated");
        }
    }
}
