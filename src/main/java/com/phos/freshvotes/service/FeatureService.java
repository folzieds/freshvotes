package com.phos.freshvotes.service;

import com.phos.freshvotes.Entity.Feature;
import com.phos.freshvotes.exceptions.FeatureServiceException;
import com.phos.freshvotes.exceptions.ProductServiceException;
import org.springframework.stereotype.Service;

/**
 * Created by Folarin on 13/10/2020
 */
@Service
public interface FeatureService {

    Feature getFeatures();

    Feature createFeature(Long productId) throws ProductServiceException;

    Feature getFeature(Long featureId) throws FeatureServiceException;

    Feature updateFeature(Feature feature);
}
