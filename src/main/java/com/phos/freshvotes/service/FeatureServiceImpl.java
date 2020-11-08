package com.phos.freshvotes.service;

import com.phos.freshvotes.Entity.Feature;
import com.phos.freshvotes.Entity.Product;
import com.phos.freshvotes.exceptions.FeatureServiceException;
import com.phos.freshvotes.exceptions.ProductServiceException;
import com.phos.freshvotes.repositories.FeatureRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

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
            logger.info("Creating a new Feature...");
            Product product = productService.getProduct(productId);
            logger.info("Creating feature for product: " + product.getName());
            Feature feature = new Feature();
            feature.setProduct(product);
            feature.setStatus("Pending Review");
            product.getFeatures().add(feature);
            logger.info("Feature created and add to product...");

            return featureRepository.save(feature);
        } catch (ProductServiceException e) {
            throw new ProductServiceException("Product with Id" + productId + " could not be updated");
        }
    }

    @Override
    public Feature getFeature(Long featureId) throws FeatureServiceException {
        Optional<Feature> feature = featureRepository.findById(featureId);

        if (feature.isPresent()){
            logger.info("Feature found with Id " + featureId);
            return feature.get();
        }else{
            throw new FeatureServiceException("Could not find feature with Id " + featureId);
        }
    }

    @Override
    public Feature updateFeature(Feature feature){
        return featureRepository.save(feature);
    }
}
